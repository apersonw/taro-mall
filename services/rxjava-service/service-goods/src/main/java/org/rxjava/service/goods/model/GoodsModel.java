package org.rxjava.service.goods.model;

import lombok.Data;
import org.rxjava.common.core.entity.Image;
import org.rxjava.service.goods.status.GoodsStatus;
import org.rxjava.service.goods.type.ExcessType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-03-23 00:19
 */
@Data
public class GoodsModel {
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
     * 售价
     */
    private int coverPrice;
    /**
     * 默认为虚拟商品
     */
    private String type;
    /**
     * 标签
     */
    private List<String> tags;
}
