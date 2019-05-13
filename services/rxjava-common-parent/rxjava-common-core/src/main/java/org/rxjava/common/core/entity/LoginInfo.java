package org.rxjava.common.core.entity;

import lombok.Data;

/**
 * @author happy 2019-04-14 14:00
 * 登陆信息
 */
@Data
public class LoginInfo {
    /**
     * 用户Id（用户则代表userId，管理员代表为managerId）
     */
    private String userId;
}
