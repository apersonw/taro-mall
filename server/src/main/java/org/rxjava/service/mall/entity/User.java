package org.rxjava.service.mall.entity;

import lombok.Data;
import org.rxjava.service.mall.status.UserStatus;
import org.rxjava.service.mall.type.SexType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-03-17 23:21
 * 手机号为必填
 */
@Data
@Document
public class User {
    @Id
    private String id;
    /**
     * 账号
     */
    @Indexed
    private String username;
    /**
     * 手机号
     */
    @Indexed(unique = true)
    private String phone;
    /**
     * 邮箱
     */
    @Indexed
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex = SexType.SECRET.name();
    /**
     * 头像
     */
    private String headImage;
    /**
     * 签名
     */
    private String signature;
    /**
     * 状态
     */
    private String status = UserStatus.NORMAL.name();
    @CreatedDate
    @Indexed(direction = DESCENDING)
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;
}
