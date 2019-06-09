package org.rxjava.service.goods.model;

import lombok.Data;
import org.rxjava.common.core.entity.Resource;
import org.rxjava.service.goods.entity.Sku;

import java.util.List;

/**
 * @author happy 2019-03-23 00:19
 */
@Data
public class GoodsDetailModel {
    private String id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 缩略图
     */
    private Resource thumb;
    /**
     * 售价
     */
    private int coverPrice;
    /**
     *
     */
    private List<Sku> skus;
}
