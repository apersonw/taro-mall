package org.rxjava.service.goods.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.rxjava.service.goods.status.GoodsStatus;
import org.rxjava.service.goods.type.ExcessType;
import org.rxjava.service.goods.type.GoodsType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

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
     * 标题
     */
    @Indexed
    private String title;
    /**
     * 卖点
     */
    private String sellingPoint;
    /**
     * 缩略图
     */
    private Image thumb;
    /**
     * 分享描述
     */
    private String desc;
    /**
     * 类目Id
     */
    private ObjectId categoryId;
    /**
     * 品牌Id
     */
    private ObjectId brandId;
    /**
     * 默认为虚拟商品
     */
    @Indexed
    private String type = GoodsType.VIRTUAL.name();
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
     * 标签
     */
    @Indexed
    private List<String> tags;
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
