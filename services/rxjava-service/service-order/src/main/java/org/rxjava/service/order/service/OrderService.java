package org.rxjava.service.order.service;

import org.rxjava.service.order.entity.Order;
import org.rxjava.service.order.form.OrderPageForm;
import org.rxjava.service.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-04-29 23:45
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Mono<Page<Order>> findPage(OrderPageForm form, Pageable pageable) {
        return orderRepository
                .findPage(form, pageable);
    }
}
