package org.rxjava.service.goods.entity;

import lombok.Data;
import org.rxjava.common.core.entity.Resource;
import org.rxjava.service.goods.status.CategoryStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-03-17 23:22
 */
@Data
@Document
public class Category {
    /**
     * ID
     */
    @Id
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
     * 分类状态
     */
    private String status = CategoryStatus.NORMAL.name();
    /**
     * 缩略图
     */
    private Resource thumb;
    /**
     * 创建日期
     */
    @CreatedDate
    @Indexed(direction = DESCENDING)
    private LocalDateTime createDate;
    /**
     * 更新日期
     */
    @LastModifiedDate
    private LocalDateTime updateDate;
}
