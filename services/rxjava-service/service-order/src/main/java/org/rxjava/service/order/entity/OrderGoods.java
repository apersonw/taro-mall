package org.rxjava.service.order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author happy 2019-04-22 20:22
 * 订单商品
 */
@Data
public class OrderGoods {
    @Id
    private String id;
    private String orderId;
    private String goodsId;
    private String userId;
}
