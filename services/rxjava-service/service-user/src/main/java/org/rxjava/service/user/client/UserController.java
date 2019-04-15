package org.rxjava.service.user.client;

import org.apache.commons.lang3.RandomStringUtils;
import org.rxjava.service.user.LoginByPhoneSmsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-14 01:14
 */
@RestController
public class UserController {
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    /**
     * 手机验证码登陆
     */
    @PostMapping("loginByPhoneSms")
    public Mono<String> loginByPhoneSms(
            @Valid LoginByPhoneSmsForm form
    ) {
        return Mono.just(RandomStringUtils.random(32));
    }
}
