package org.rxjava.service.order.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.order.entity.Order;
import org.rxjava.service.order.form.OrderPageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface OrderRepository extends ReactiveSortingRepository<Order, String>, SpecialOrderRepository {

}

interface SpecialOrderRepository {
    Mono<Page<Order>> findPage(OrderPageForm form, Pageable pageable);
}

class SpecialOrderRepositoryImpl implements SpecialOrderRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<Order> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, Order.class);
    }

    @Override
    public Mono<Page<Order>> findPage(OrderPageForm form, Pageable pageable) {
        Query query = new Query();
        return pageAgent.findPage(query, pageable);
    }
}