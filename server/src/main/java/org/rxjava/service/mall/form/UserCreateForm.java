package org.rxjava.service.mall.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.rxjava.service.mall.status.UserStatus;
import org.rxjava.service.mall.type.SexType;

import javax.validation.constraints.NotBlank;

/**
 * @author happy 2019-03-21 23:34
 */
@Data
public class UserCreateForm {
    /**
     * 账号
     */
    private String username;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "请输入11位手机号码")
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 8, max = 64, message = "请输入8-64位长度密码")
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
}
