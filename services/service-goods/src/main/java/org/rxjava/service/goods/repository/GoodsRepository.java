package org.rxjava.service.goods.repository;

import org.apache.commons.lang3.StringUtils;
import org.rxjava.service.goods.entity.CarouselImg;
import org.rxjava.service.goods.entity.Content;
import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.entity.Sku;
import org.rxjava.service.goods.form.GoodsListForm;
import org.rxjava.service.goods.form.GoodsPageForm;
import org.rxjava.service.goods.status.GoodsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author happy 2019-03-23 00:17
 */
@Repository
public interface GoodsRepository extends ReactiveSortingRepository<Goods, String>, SpecialGoodsRepository {
}

interface SpecialGoodsRepository {

    Flux<Goods> getList(GoodsListForm form);

    Mono<Goods> getByGoodsId(String goodsId);

    Flux<Content> getContentList(String goodsId);

    Flux<Sku> getSkuList(String goodsId);

    Flux<CarouselImg> getCarouselImgList(String goodsId);

    Mono<Page<Goods>> getPage(GoodsPageForm form);
}

class SpecialGoodsRepositoryImpl implements SpecialGoodsRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<Goods> getList(GoodsListForm form) {
        Criteria criteria = new Criteria();
        if (StringUtils.isNotEmpty(form.getBrandId())) {
            criteria.and("brandId").is(form.getBrandId());
        }
        if (StringUtils.isNotEmpty(form.getCategoryId())) {
            criteria.and("categoryId").is(form.getCategoryId());
        }
        Query query = Query.query(criteria);
        return reactiveMongoTemplate
                .find(query, Goods.class);
    }

    @Override
    public Mono<Goods> getByGoodsId(String goodsId) {
        Criteria criteria = Criteria
                .where("id").is(goodsId)
                .and("org/rxjava/service/goods/status").is(GoodsStatus.NORMAL.name());
        Query query = Query.query(criteria);
        return reactiveMongoTemplate
                .findOne(query, Goods.class);
    }

    @Override
    public Flux<Content> getContentList(String goodsId) {
        return reactiveMongoTemplate
                .find(Query.query(Criteria.where("goodsId").is(goodsId)), Content.class);
    }

    @Override
    public Flux<Sku> getSkuList(String goodsId) {
        return reactiveMongoTemplate
                .find(Query.query(Criteria.where("goodsId").is(goodsId)), Sku.class);
    }

    @Override
    public Flux<CarouselImg> getCarouselImgList(String goodsId) {
        return reactiveMongoTemplate
                .find(Query.query(Criteria.where("goodsId").is(goodsId)), CarouselImg.class);
    }

    @Override
    public Mono<Page<Goods>> getPage(GoodsPageForm form) {
        Query query = new Query();
        return Mono
                .zip(
                        reactiveMongoTemplate.find(query, Goods.class).collectList(),
                        reactiveMongoTemplate.count(query, Goods.class)
                )
                .map(z -> {
                    List<Goods> goodsList = z.getT1();
                    Long num = z.getT2();
                    return new PageImpl<>(goodsList, PageRequest.of(form.getPage(), form.getPageSize()), num);
                });
    }
}
