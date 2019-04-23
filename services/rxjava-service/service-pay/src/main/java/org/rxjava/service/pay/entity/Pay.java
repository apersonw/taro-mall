package org.rxjava.service.pay.entity;

import lombok.Data;
import org.rxjava.service.pay.status.PayStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-03-29 13:46
 */
@Data
@Document
public class Pay {
    @Id
    private String id;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 商铺Id
     */
    private String shopId;
    /**
     * 支付状态: 初始化->成功或失败
     */
    private String status = PayStatus.INIT.name();
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
