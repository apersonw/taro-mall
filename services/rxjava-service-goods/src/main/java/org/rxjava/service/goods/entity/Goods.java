package org.rxjava.service.goods.entity;

import lombok.Data;
import org.rxjava.common.core.entity.Image;
import org.rxjava.service.goods.status.GoodsStatus;
import org.rxjava.service.goods.type.ExcessType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-03-17 23:22
 * 商品
 */
@Data
@Document
public class Goods {
    @Id
    private String id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 缩略图
     */
    private Image thumb;
    /**
     * 品牌Id
     */
    private String brandId;
    /**
     * 商铺Id
     */
    private String shopId;
    /**
     * 封面价
     */
    private int coverPrice;
    /**
     * 默认为虚拟商品
     */
    @Indexed
    private String type;
    /**
     * 商品状态
     */
    @Indexed
    private String status = GoodsStatus.INIT.name();
    /**
     * 优先级
     */
    private int priority;
    /**
     * 超售，默认不允许
     */
    private String excess = ExcessType.NOTALLOWED.name();
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
