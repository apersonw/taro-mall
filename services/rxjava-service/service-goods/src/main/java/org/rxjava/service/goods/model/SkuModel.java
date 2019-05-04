package org.rxjava.service.goods.model;

import io.lettuce.core.KeyValue;
import lombok.Data;
import org.rxjava.common.core.entity.Resource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
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
    private Resource skuImg;
    /**
     * SKU属性列表
     */
    private List<KeyValue<String, String>> params;
}
