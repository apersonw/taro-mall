package org.rxjava.service.user.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rxjava.common.core.annotation.Login;
import org.rxjava.common.core.entity.LoginInfo;
import org.rxjava.common.core.exception.ErrorMessageException;
import org.rxjava.common.core.utils.UUIDUtils;
import org.rxjava.service.user.entity.User;
import org.rxjava.service.user.entity.UserAuth;
import org.rxjava.service.user.form.LoginByPhoneSmsForm;
import org.rxjava.service.user.form.UserSaveForm;
import org.rxjava.service.user.model.UserModel;
import org.rxjava.service.user.repository.UserAuthRepository;
import org.rxjava.service.user.repository.UserRepository;
import org.rxjava.service.user.serve.ServeUserController;
import org.rxjava.service.user.type.IdentityType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

/**
 * @author happy 2019-04-14 01:14
 */
@RestController
public class UserController {
    private static final Logger log = LogManager.getLogger();
    private static final int TOKEN_LENGTH = 32;

    @Autowired
    private UserAuthRepository userAuthRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 手机验证码登陆(若手机号不存在则创建手机类型账号)
     */
    @Login(false)
    @PostMapping("loginByPhoneSms")
    public Mono<String> loginByPhoneSms(
            @Valid LoginByPhoneSmsForm form
    ) {
        return userAuthRepository
                .findByIdentityTypeAndIdentifier(IdentityType.PHONE.name(), form.getPhone())
                .switchIfEmpty(Mono.just(new UserAuth()).flatMap(userAuth -> {
                    userAuth.setIdentityType(IdentityType.PHONE.name());
                    userAuth.setIdentifier(form.getPhone());
                    return userAuthRepository
                            .save(userAuth);
                }))
                .flatMap(userAuth -> {
                    String token = newToken();
                    LoginInfo loginInfo = new LoginInfo();
                    loginInfo.setUserId(userAuth.getUserId());
                    loginInfo.setIdentityType(userAuth.getIdentityType());
                    loginInfo.setUserAuthId(userAuth.getId());
                    String loginInfoStr;
                    try {
                        loginInfoStr = objectMapper.writeValueAsString(loginInfo);
                    } catch (JsonProcessingException e) {
                        throw ErrorMessageException.of("登陆信息解析json错误");
                    }
                    return reactiveRedisTemplate
                            .opsForValue()
                            .set(token, loginInfoStr, Duration.ofMinutes(120))
                            .map(b -> token);
                });
    }

    /**
     * 查询当前登陆的用户信息
     */
    @GetMapping("currentUser")
    public Mono<UserModel> getCurrentUser(
            LoginInfo loginInfo
    ) {
        log.info(loginInfo);
        if (StringUtils.isNotEmpty(loginInfo.getIdentityType()) && StringUtils.isEmpty(loginInfo.getUserId())) {
            throw ErrorMessageException.of("用户已注册账号，但未填写用户基本信息");
        }
        return userRepository
                .findById(loginInfo.getUserId())
                .map(user -> {
                    UserModel userModel = new UserModel();
                    BeanUtils.copyProperties(user, userModel);
                    return userModel;
                });
    }

    /**
     * 保存用户信息
     */
    @PostMapping("user")
    public Mono<UserModel> saveUser(
            @Valid UserSaveForm form,
            LoginInfo loginInfo
    ) {
        log.info("saveUser:{}", form);
        return Mono
                .justOrEmpty(loginInfo.getUserId())
                .flatMap(userId -> userRepository.findById(userId))
                .switchIfEmpty(Mono.just(new User()))
                .flatMap(user -> {
                    BeanUtils.copyProperties(form, user, "token");
                    return userRepository
                            .save(user)
                            .doOnSuccess(u -> userAuthRepository
                                    .updateUserIdById(loginInfo.getUserAuthId(), u.getId())
                                    .subscribe()
                            );
                })
                .map(this::transformUserModel);
    }

    private UserModel transformUserModel(User user) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        return userModel;
    }

    @Login(false)
    @GetMapping("/")
    public Mono<String> system() {
        return Mono.just("用户服务正常");
    }

    private String newToken() {
        String uuid = UUIDUtils.randomUUIDToBase64();
        return uuid + RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH - uuid.length());
    }
}
