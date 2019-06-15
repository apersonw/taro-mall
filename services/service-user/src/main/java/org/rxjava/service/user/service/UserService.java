package org.rxjava.service.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rxjava.common.core.entity.LoginInfo;
import org.rxjava.common.core.exception.ErrorMessageException;
import org.rxjava.common.core.exception.LoginRuntimeException;
import org.rxjava.service.user.entity.User;
import org.rxjava.service.user.form.UserPageForm;
import org.rxjava.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * @author happy 2019-04-22 20:20
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public Mono<Page<User>> findPage(UserPageForm form, Pageable pageable) {
        return userRepository
                .findPage(form, pageable);
    }

    public Mono<LoginInfo> getLoginInfoByToken(String token) {
        return reactiveRedisTemplate
                .opsForValue()
                .get(token)
                .map(loginInfoStr -> {
                    LoginInfo loginInfo;
                    try {
                        loginInfo = objectMapper.readValue(loginInfoStr, LoginInfo.class);
                    } catch (IOException e) {
                        throw ErrorMessageException.of("登陆信息解析异常");
                    }
                    return loginInfo;
                });
    }
}
