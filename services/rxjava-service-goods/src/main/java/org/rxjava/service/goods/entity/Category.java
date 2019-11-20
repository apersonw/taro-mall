package org.rxjava.service.goods.entity;

import lombok.Getter;
import lombok.Setter;
import org.rxjava.common.core.entity.BaseEntity;
import org.rxjava.common.core.entity.Image;
import org.rxjava.service.goods.status.CategoryStatus;

/**
 * @author happy 2019-03-17 23:22
 */
@Getter
@Setter
public class Category extends BaseEntity {
    /**
     * 上级Id
     */
    private String parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 分类状态
     */
    private String status = CategoryStatus.NORMAL.name();
    /**
     * 缩略图
     */
    private Image thumb;
}
