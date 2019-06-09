package org.rxjava.service.goods.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.goods.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

/**
 * @author happy 2019-03-23 00:17
 */
@Repository
public interface SkuRepository extends ReactiveSortingRepository<Sku, String>, SpecialSkuRepository {
    Flux<Sku> findByGoodsId(String goodsId);
}

interface SpecialSkuRepository {
}

class SpecialSkuRepositoryImpl implements SpecialSkuRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<Sku> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, Sku.class);
    }
}
