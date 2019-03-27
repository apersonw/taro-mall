package org.rxjava.service.goods.entity;

import lombok.Data;
import org.rxjava.service.goods.status.ResourceStatus;
import org.rxjava.service.goods.type.ResourceType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * 资源
 */
@Data
@Document
public class Resource {
    @Id
    private String id;
    /**
     * 唯一key(资源码)
     */
    @Indexed(unique = true)
    private String key;
    /**
     * 类型
     */
    private String type = ResourceType.BANNER.name();
    /**
     * 名称
     */
    @TextIndexed
    private String name;
    /**
     * 正常NORMAL,下线OFFLINE
     */
    @Indexed
    private String status = ResourceStatus.NORMAL.name();
    /**
     * 图片KEY列表
     */
    private List<Image> imgKeys;
    /**
     * 缩略图
     */
    private Image thumb;
    /**
     * 开始时间
     */
    private LocalDateTime startDate;
    /**
     * 结束时间
     */
    private LocalDateTime endDate;
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
