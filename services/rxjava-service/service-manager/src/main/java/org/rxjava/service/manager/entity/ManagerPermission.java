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
 * @author happy 2019-05-08 15:15
 * 管理者-权限
 */
@Data
@Document
@CompoundIndexes({
        @CompoundIndex(
                name = "manager_permission",
                def = "{'managerId':1,'permission':1}",
                unique = true
        ),
        @CompoundIndex(
                name = "path_method",
                def = "{'path':1,'method':1}",
                unique = true
        )
})
public class ManagerPermission {
    @Id
    private String id;
    private String managerId;
    private String permissionId;
    /**
     * 权限路径
     */
    private String path;
    /**
     * 请求方法
     */
    private String method;
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
