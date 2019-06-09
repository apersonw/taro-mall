package org.rxjava.service.card.entity;

import lombok.Data;
import org.rxjava.service.card.status.UserCouponStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-04-23 02:36
 * 优惠券
 */
@Data
public class Coupon {
    @Id
    private String id;
    /**
     * 店铺Id
     */
    private String shopId;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 分类Id
     */
    private String categoryId;
    /**
     * 类型：直减/折扣
     */
    private String type;
    /**
     * 直减，则单位为分，折扣，则为百分比
     */
    private int value;
    /**
     * 状态
     */
    private String status = UserCouponStatus.INIT.name();
    /**
     * 创建日期
     */
    @CreatedDate
    @Indexed(direction = DESCENDING)
    private LocalDateTime createDate;
    /**
     * 更新日期
     */
    @LastModifiedDate
    private LocalDateTime updateDate;
}
