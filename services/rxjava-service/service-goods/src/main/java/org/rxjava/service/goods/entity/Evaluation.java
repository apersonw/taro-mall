package org.rxjava.service.goods.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

/**
 * @author happy 2019-04-15 23:41
 * 评价
 */
@Data
public class Evaluation {
    @Id
    private String id;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 创建日期
     */
    @CreatedDate
    @Indexed(direction = IndexDirection.DESCENDING)
    private LocalDateTime createDate;
}
