package org.rxjava.service.vipcard.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-04-23 02:38
 * 券码批次信息
 */
@Data
public class CouponBatch {
    @Id
    private String id;
    /**
     * 描述
     */
    private String desc;
    /**
     * 券码Id
     */
    private String couponId;
    /**
     * 状态
     */
    private String status;
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
