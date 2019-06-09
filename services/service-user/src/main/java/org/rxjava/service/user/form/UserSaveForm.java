package org.rxjava.service.user.form;

import lombok.Data;
import org.rxjava.common.core.entity.Resource;

import javax.validation.constraints.NotEmpty;

/**
 * @author happy 2019-05-15 23:14
 */
@Data
public class UserSaveForm {
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private Resource avatar;
}
