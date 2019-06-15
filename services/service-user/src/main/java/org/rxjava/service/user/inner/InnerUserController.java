package org.rxjava.service.user.inner;

import org.rxjava.common.core.entity.LoginInfo;
import org.rxjava.service.user.entity.User;
import org.rxjava.service.user.repository.UserRepository;
import org.rxjava.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-05-15 22:22
 * 用户内部接口
 */
@RestController
@RequestMapping("inner")
public class InnerUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    /**
     * token换取loginInfo，不做空异常抛出
     */
    @GetMapping("token/{token}/logininfo")
    public Mono<LoginInfo> tokenToLoginInfo(
            @PathVariable String token
    ) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUserAuthId("userAuthId");
        loginInfo.setIdentityType("identityType");
        loginInfo.setUserId("userId");
        return Mono.just(loginInfo);
//        return userService.getLoginInfoByToken(token);
    }

    @GetMapping("token/{token}/user")
    public Mono<User> tokenToUser(
            @PathVariable String token
    ) {
        return userService.getLoginInfoByToken(token)
                .flatMap(loginInfo -> userRepository.findById(loginInfo.getUserId()));
    }
}
