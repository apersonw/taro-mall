package org.rxjava.service.user.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author happy 2019-04-15 22:59
 */
@Data
public class LoginByPhoneSmsForm {
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "请输入11位手机号码")
    private String phone;
    /**
     * 短信验证码
     */
    @NotBlank(message = "验证码不能为空")
    @Length(min = 6, max = 6, message = "请输入6位短信验证码")
    private String sms;
}
