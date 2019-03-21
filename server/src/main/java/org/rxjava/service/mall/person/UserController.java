package org.rxjava.service.mall.person;

import org.rxjava.service.mall.annotation.Account;
import org.rxjava.service.mall.form.UserCreateForm;
import org.rxjava.service.mall.form.UserListForm;
import org.rxjava.service.mall.model.UserModel;
import org.rxjava.service.mall.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-03-17 23:27
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @Account(false)
    @PostMapping("user")
    public Mono<UserModel> create(
            @Valid UserCreateForm form
    ) {
        return userService
                .create(form);
    }

    /**
     * 查询用户列表
     */
    @GetMapping("userList")
    public Flux<UserModel> getList(
            @Valid UserListForm form
    ) {
        return userService
                .getList(form);
    }
}
