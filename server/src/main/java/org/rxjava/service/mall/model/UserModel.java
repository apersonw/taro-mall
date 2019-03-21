package org.rxjava.service.mall.model;

import lombok.Data;
import org.rxjava.service.mall.status.UserStatus;
import org.rxjava.service.mall.type.SexType;

import java.time.LocalDateTime;

/**
 * @author happy 2019-03-21 23:13
 */
@Data
public class UserModel {
    private String id;
    /**
     * 账号
     */
    private String username;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
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
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
