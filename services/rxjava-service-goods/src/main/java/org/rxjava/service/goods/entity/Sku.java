package org.rxjava.service.goods.entity;

import io.lettuce.core.KeyValue;
import lombok.Getter;
import lombok.Setter;
import org.rxjava.common.core.entity.BaseEntity;
import org.rxjava.common.core.entity.Image;

import java.util.List;

/**
 * @author happy 2019-03-21 22:46
 * 商品Sku
 */
@Getter
@Setter
public class Sku extends BaseEntity {
    /**
     * 商品ID
     */
    private String goodsId;
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
