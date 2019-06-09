package org.rxjava.service.manager.entity;

import lombok.Data;
import org.rxjava.common.core.entity.Resource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-04-27 00:05
 */
@Data
@Document
public class Manager {
    @Id
    private String id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private Resource avatar;
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
