package org.rxjava.service.user.model;

import lombok.Data;
import org.rxjava.common.core.entity.Resource;

/**
 * @author happy 2019-05-15 21:59
 */
@Data
public class UserModel {
    private String id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private Resource avatar;
}
