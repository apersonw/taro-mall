package org.rxjava.service.coupon.entity;

import lombok.Data;
import org.rxjava.common.core.entity.KeyValue;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @author happy 2019-04-22 15:44
 * 商品评估
 */
@Data
public class GoodsAppraisal {
    @Id
    private String id;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 商铺Id
     */
    private String shopId;
    /**
     * 评价标签列表
     */
    private List<KeyValue<String, String>> labels;
}
