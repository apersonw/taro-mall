package org.rxjava.service.manager.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-05-08 15:08
 * 管理者-角色
 */
@Data
@Document
@CompoundIndexes(
        @CompoundIndex(
                name = "manager_role",
                def = "{'managerId':1,'roleId':1}",
                unique = true
        )
)
public class ManagerRole {
    @Id
    private String id;
    private String managerId;
    private String roleId;
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
