package org.rxjava.service.goods.model;

import lombok.Data;
import org.rxjava.common.core.entity.Resource;

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
    private Resource thumb;
    /**
     * 售价
     */
    private int coverPrice;
}
