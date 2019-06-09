package org.rxjava.service.link.entity;

import lombok.Data;
import org.rxjava.common.core.status.Status;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-04-27 10:29
 * 链接位置
 */
@Data
@Document
public class LinkLocation {
    @Id
    private String id;
    /**
     * 位置名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 位置状态
     */
    private String status = Status.NORMAL.name();
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
