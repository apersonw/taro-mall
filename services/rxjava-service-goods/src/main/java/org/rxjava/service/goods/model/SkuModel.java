package org.rxjava.service.goods.model;

import lombok.Data;
import org.rxjava.common.core.entity.Image;
import org.rxjava.common.core.entity.KeyValue;

import java.util.List;

/**
 * @author happy 2019-03-21 22:46
 * 商品Sku
 */
@Data
public class SkuModel {
    /**
     * ID
     */
    private String id;
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
