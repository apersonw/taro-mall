package org.rxjava.service.goods.model;

import lombok.Data;
import org.rxjava.common.core.entity.Resource;

/**
 * @author happy 2019-03-25 23:13
 */
@Data
public class CategoryModel {
    /**
     * ID
     */
    private String id;
    /**
     * 上级Id
     */
    private String parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 缩略图
     */
    private Resource thumb;
}
