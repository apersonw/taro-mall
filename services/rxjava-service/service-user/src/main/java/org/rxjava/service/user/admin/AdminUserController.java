package org.rxjava.service.user.admin;

import org.rxjava.common.core.annotation.Login;
import org.rxjava.service.user.entity.User;
import org.rxjava.service.user.form.UserPageForm;
import org.rxjava.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-27 00:02
 */
@RequestMapping("admin")
@RestController
public class AdminUserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户分页
     */
    @Login(false)
    @GetMapping("userPage")
    public Mono<Page<User>> getPage(
            @Valid UserPageForm form
    ) {
        return userService
                .findPage(form, PageRequest.of(form.getPage(), form.getPageSize()));
    }
}
