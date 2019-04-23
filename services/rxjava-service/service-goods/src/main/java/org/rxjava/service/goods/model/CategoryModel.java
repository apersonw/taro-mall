package org.rxjava.service.goods.model;

import lombok.Data;
import org.rxjava.common.core.entity.Image;
import org.rxjava.service.goods.status.CategoryStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

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
    private Image thumb;
}
