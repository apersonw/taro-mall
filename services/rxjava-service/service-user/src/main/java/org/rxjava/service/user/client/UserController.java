package org.rxjava.service.user.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rxjava.service.core.annotation.Login;
import org.rxjava.service.starter.boot.LoginInfo;
import org.rxjava.service.user.form.LoginByPhoneSmsForm;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-04-14 01:14
 */
@RestController
@Validated
public class UserController {
    private static final Logger log = LogManager.getLogger();

    /**
     * 手机验证码登陆
     */
    @Login(false)
    @PostMapping("loginByPhoneSms")
    public Mono<String> loginByPhoneSms(
            @Validated LoginByPhoneSmsForm form
    ) {
        return Mono.just("赵六");
    }

    /**
     * 查询当前登陆的用户信息
     */
    @GetMapping("currentUser")
    public Mono<String> getCurrentUser(
            LoginInfo loginInfo
    ) {
        log.info(loginInfo);
        return Mono.just("赵六");
    }
}
