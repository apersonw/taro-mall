package org.rxjava.service.order.client;

import org.rxjava.service.order.form.CreateOrderForm;
import org.rxjava.service.order.model.OrderModel;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-15 23:13
 */
@RestController
public class OrderController {
    /**
     * 创建订单
     */
    public Mono<OrderModel> createOrder(
            @Valid CreateOrderForm form
    ) {
        return Mono.just(new OrderModel());
    }
}
