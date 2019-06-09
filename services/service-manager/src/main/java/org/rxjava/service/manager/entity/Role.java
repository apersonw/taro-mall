package org.rxjava.service.manager.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-05-08 13:57
 * 角色
 */
@Data
@Document
public class Role {
    @Id
    private String id;
    /**
     * 上级角色Id
     */
    private String parentId;
    /**
     * 角色名称
     */
    @Indexed(unique = true)
    private String name;
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
