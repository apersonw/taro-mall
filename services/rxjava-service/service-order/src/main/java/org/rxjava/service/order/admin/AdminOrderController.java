package org.rxjava.service.order.admin;

import org.rxjava.service.order.entity.Order;
import org.rxjava.service.order.form.OrderPageForm;
import org.rxjava.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-27 00:02
 */
@RequestMapping("admin")
@RestController
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单分页
     */
    @GetMapping("orderPage")
    public Mono<Page<Order>> getPage(
            @Valid OrderPageForm form
    ) {
        return orderService
                .findPage(form, PageRequest.of(form.getPage(), form.getPageSize()));
    }
}
