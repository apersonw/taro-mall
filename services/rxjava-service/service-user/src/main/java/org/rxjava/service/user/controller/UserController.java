package org.rxjava.service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-04-14 01:14
 */
@RestController
public class UserController {
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    @GetMapping("user")
    public Mono<Boolean> getUser() {
        return reactiveRedisTemplate.opsForValue().set("hello", "nihao");
    }
}
