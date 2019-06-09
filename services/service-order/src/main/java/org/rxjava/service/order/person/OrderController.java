package org.rxjava.service.order.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rxjava.common.core.annotation.Login;
import org.rxjava.common.core.entity.LoginInfo;
import org.rxjava.service.order.entity.Order;
import org.rxjava.service.order.form.AlipayNotifyForm;
import org.rxjava.service.order.form.CreateOrderForm;
import org.rxjava.service.order.model.OrderModel;
import org.rxjava.service.order.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-15 23:13
 */
@RestController
public class OrderController {
    private static final Logger log = LogManager.getLogger();
    @Autowired
    private OrderRepository orderRepository;

    /**
     * 创建订单
     */
    @PostMapping("order")
    public Mono<OrderModel> createOrder(
            @Valid CreateOrderForm form,
            LoginInfo loginInfo
    ) {
        Order order = new Order();
        BeanUtils.copyProperties(form, order);
        order.setUserId(loginInfo.getUserId());
        return orderRepository
                .save(order)
                .map(this::transform);
    }

    /**
     * 支付宝回调
     */
    @PostMapping(value = "alipayNotify")
    @Login(false)
    public Mono<Void> alipayNotify(
            ServerWebExchange exchange,
            AlipayNotifyForm form
    ) {
        log.info("收到通知obj:{}", form);
        //fixme:待写收到通知后的处理
        return Mono.just(form)
                .then(exchange.getResponse().writeAndFlushWith(r -> Mono.just("success")));
    }

    private OrderModel transform(Order order) {
        OrderModel orderModel = new OrderModel();
        BeanUtils.copyProperties(order, orderModel);
        return orderModel;
    }

    /**
     * 微信支付回调
     */
    @PostMapping(value = "weixinNotify")
    @Login(false)
    public Mono<Void> weixinNotify(
            ServerWebExchange exchange, @RequestBody String body
    ) {
        log.info("收到通知:{}", body);
        //fixme:待写收到通知后的处理
        return Mono
                .just(body)
                .then(exchange.getResponse().writeAndFlushWith(r -> Mono.just("<xml>\n" +
                        "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                        "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                        "</xml>\n"))
                );
    }
}
