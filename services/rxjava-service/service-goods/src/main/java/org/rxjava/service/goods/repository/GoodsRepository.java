package org.rxjava.service.goods.repository;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.rxjava.service.goods.entity.CarouselImg;
import org.rxjava.service.goods.entity.Content;
import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.entity.Sku;
import org.rxjava.service.goods.form.GoodsListForm;
import org.rxjava.service.goods.form.GoodsPageForm;
import org.rxjava.service.goods.status.GoodsStatus;
import org.rxjava.service.starter.mongo.PageAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author happy 2019-03-23 00:17
 */
@Repository
public interface GoodsRepository extends ReactiveSortingRepository<Goods, String>, SpecialGoodsRepository {
}

interface SpecialGoodsRepository {

    Flux<Goods> getList(Pageable pageable, GoodsListForm form);

    Mono<Goods> getByGoodsId(String goodsId);

    Flux<Content> getContentList(String goodsId);

    Flux<Sku> getSkuList(String goodsId);

    Flux<CarouselImg> getCarouselImgList(String goodsId);

    Mono<Page<Goods>> findPage(Pageable pageable, GoodsPageForm form);
}

class SpecialGoodsRepositoryImpl implements SpecialGoodsRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<Goods> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, Goods.class);
    }

    @Override
    public Flux<Goods> getList(Pageable pageable, GoodsListForm form) {
        Criteria criteria = new Criteria();
        if (StringUtils.isNotEmpty(form.getBrandId())) {
            criteria.and("brandId").is(form.getBrandId());
        }
        if (StringUtils.isNotEmpty(form.getCategoryId())) {
            criteria.and("categoryId").is(form.getCategoryId());
        }
        if (!CollectionUtils.isEmpty(form.getGoodsIds())) {
            criteria.and("id").in(form.getGoodsIds());
        }
        Query query = Query.query(criteria).with(pageable);
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
    public Mono<Page<Goods>> findPage(Pageable pageable, GoodsPageForm form) {
        Query query = new Query();
        query.with(pageable);
        return pageAgent.findPage(query, pageable);
    }
}
