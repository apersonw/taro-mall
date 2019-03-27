package org.rxjava.service.goods.repository;

import org.apache.commons.lang3.StringUtils;
import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.form.GoodsQueryForm;
import org.rxjava.service.goods.status.GoodsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-23 00:17
 */
@Repository
public interface GoodsRepository extends ReactiveSortingRepository<Goods, String>, SpecialGoodsRepository {
}

interface SpecialGoodsRepository {

    Flux<Goods> getList(GoodsQueryForm form);

    Mono<Goods> getByGoodsId(String goodsId);
}

class SpecialGoodsRepositoryImpl implements SpecialGoodsRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<Goods> getList(GoodsQueryForm form) {
        Criteria criteria = new Criteria();
        if (StringUtils.isNotEmpty(form.getBrandId())) {
            criteria.and("brandId").is(form.getBrandId());
        }
        if (StringUtils.isNotEmpty(form.getCategoryId())) {
            criteria.and("categoryId").is(form.getCategoryId());
        }
        //// TODO: 2019-03-23 剩余的两个条件使用到的时候写
        Query query = Query.query(criteria);
        return reactiveMongoTemplate
                .find(query, Goods.class);
    }

    @Override
    public Mono<Goods> getByGoodsId(String goodsId) {
        Criteria criteria = Criteria
                .where("id").is(goodsId)
                .and("status").is(GoodsStatus.NORMAL.name());
        Query query = Query.query(criteria);
        return reactiveMongoTemplate
                .findOne(query, Goods.class);
    }
}
