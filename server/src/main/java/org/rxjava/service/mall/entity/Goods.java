package org.rxjava.service.mall.entity;

import lombok.Data;
import org.rxjava.service.mall.status.GoodsStatus;
import org.rxjava.service.mall.type.ExcessType;
import org.rxjava.service.mall.type.GoodsType;
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
 */
@Data
@Document
public class Goods {
    @Id
    private String id;
    /**
     * 商品名称
     */
    @Indexed
    private String name;
    /**
     * 商品状态
     */
    @Indexed
    private String status = GoodsStatus.INIT.name();
    /**
     * 商品简介
     */
    private String desc;
    /**
     * 默认为虚拟商品
     */
    @Indexed
    private String type = GoodsType.VIRTUAL.name();
    /**
     * 商品标签
     */
    @Indexed
    private List<String> labels;
    /**
     * 缩略图
     */
    private Image thumb;
    /**
     * 标价,单位分
     */
    private int markedPrice;
    /**
     * 商品售价,单位分
     */
    private int sellingPrice;
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
