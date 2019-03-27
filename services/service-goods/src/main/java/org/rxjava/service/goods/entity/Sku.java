package org.rxjava.service.goods.entity;

import io.lettuce.core.KeyValue;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author happy 2019-03-21 22:46
 * 商品Sku
 */
@Data
@Document
public class Sku {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 商品ID
     */
    private ObjectId goodsId;
    /**
     * 销售价
     */
    private long price;
    /**
     * SKU库存
     */
    private long stockNum;
    /**
     * SKU图片
     */
    private Image skuImg;
    /**
     * SKU属性列表
     */
    private List<KeyValue<String, String>> params;
}
