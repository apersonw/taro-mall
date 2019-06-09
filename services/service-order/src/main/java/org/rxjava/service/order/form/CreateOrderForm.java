package org.rxjava.service.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author happy 2019-04-15 23:15
 */
@Data
public class CreateOrderForm {
    /**
     * 商品Id
     */
    @NotEmpty(message = "商品Id不能为空")
    private String goodsId;
    /**
     * 商铺Id
     */
    @NotEmpty(message = "商铺Id不能为空")
    private String shopId;
    /**
     * 订单总价
     */
    @NotEmpty(message = "订单总价不能为空")
    private int totalPrice;
}
