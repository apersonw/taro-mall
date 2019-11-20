package org.rxjava.service.goods.entity;

import lombok.Getter;
import lombok.Setter;
import org.rxjava.common.core.entity.BaseEntity;
import org.rxjava.common.core.entity.Image;
import org.rxjava.service.goods.status.GoodsStatus;
import org.rxjava.service.goods.type.ExcessType;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author happy 2019-03-17 23:22
 * 商品
 */
@Getter
@Setter
public class Goods extends BaseEntity {
    /**
     * 商品名称
     */
    private String name;
    /**
     * 缩略图
     */
    private Image thumb;
    /**
     * 品牌Id
     */
    private String brandId;
    /**
     * 商铺Id
     */
    private String shopId;
    /**
     * 封面价
     */
    private int coverPrice;
    /**
     * 默认为虚拟商品
     */
    @Indexed
    private String type;
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
     * 超售，默认不允许
     */
    private String excess = ExcessType.NOTALLOWED.name();
}
