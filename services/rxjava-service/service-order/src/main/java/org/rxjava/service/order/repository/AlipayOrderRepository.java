package org.rxjava.service.order.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.order.entity.AlipayOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface AlipayOrderRepository extends ReactiveSortingRepository<AlipayOrder, String>, SpecialAlipayOrderRepository {

}

interface SpecialAlipayOrderRepository {
}

class SpecialAlipayOrderRepositoryImpl implements SpecialAlipayOrderRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<AlipayOrder> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, AlipayOrder.class);
    }
}