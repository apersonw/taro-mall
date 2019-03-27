package org.rxjava.service.goods.model;

import lombok.Data;
import org.rxjava.service.goods.entity.Image;
import org.rxjava.service.goods.status.GoodsStatus;
import org.rxjava.service.goods.type.ExcessType;
import org.rxjava.service.goods.type.GoodsType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author happy 2019-03-23 00:19
 */
@Data
public class GoodsModel {
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 卖点
     */
    private String sellingPoint;
    /**
     * 缩略图
     */
    private Image thumb;
    /**
     * 分享描述
     */
    private String desc;
    /**
     * 类目Id
     */
    private String categoryId;
    /**
     * 品牌Id
     */
    private String brandId;
    /**
     * 默认为虚拟商品
     */
    private String type = GoodsType.VIRTUAL.name();
    /**
     * 商品状态
     */
    private String status = GoodsStatus.INIT.name();
    /**
     * 优先级
     */
    private int priority;
    /**
     * 标签
     */
    private List<String> tags;
    /**
     * 超售，默认不允许
     */
    private String excess = ExcessType.NOTALLOWED.name();
    /**
     * 创建日期
     */
    private LocalDateTime createDate;
    /**
     * 更新日期
     */
    private LocalDateTime updateDate;
}
