package org.rxjava.service.manager.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-05-08 20:41
 * 登陆日志
 */
@Data
public class LoginLog {
    @Id
    private String id;
    private String managerId;
    /**
     * 登录类型（手机号,邮箱,用户名）或第三方应用名称（微信 微博等）
     */
    private String identityType;
    /**
     * 标识（手机号,邮箱,用户名或第三方应用的唯一标识）
     */
    private String identifier;
    private String token;
    /**
     * 创建日期
     */
    @CreatedDate
    @Indexed(direction = DESCENDING)
    private LocalDateTime createDate;
}
