package org.rxjava.service.user.serve;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rxjava.common.core.entity.LoginInfo;
import org.rxjava.common.core.exception.ErrorMessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * @author happy 2019-05-15 22:22
 * 用户服务接口(仅供微服务彼此间调用)
 */
@RequestMapping("serve")
@RestController
public class ServeUserController {
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("logininfo/{token}")
    public Mono<LoginInfo> getByToken(
            @PathVariable String token
    ) {
        return reactiveRedisTemplate
                .opsForValue()
                .get(token)
                .switchIfEmpty(ErrorMessageException.mono("登陆信息不存在"))
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
