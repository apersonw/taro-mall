package org.rxjava.service.manager.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author happy 2019-04-27 00:08
 */
@Data
public class ManagerLoginForm {
    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    @Length(min = 8, message = "账号长度不能小于8位")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 8, message = "密码长度不能小于8位")
    private String password;
}
