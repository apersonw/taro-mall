package org.rxjava.service.order.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-03-29 13:45
 */
@Data
@Document
public class Order {
    @Id
    private String id;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 商铺Id
     */
    private String shopId;
    /**
     * 商品Id
     */
    private String goodsId;
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
