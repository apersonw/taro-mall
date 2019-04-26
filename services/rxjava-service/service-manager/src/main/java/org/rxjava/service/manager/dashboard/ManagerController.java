package org.rxjava.service.manager.dashboard;

import org.apache.commons.lang.RandomStringUtils;
import org.rxjava.common.core.annotation.Login;
import org.rxjava.common.core.exception.ErrorMessageException;
import org.rxjava.common.core.utils.KeyUtils;
import org.rxjava.service.manager.entity.Manager;
import org.rxjava.service.manager.form.ManagerLoginForm;
import org.rxjava.service.manager.repository.ManagerAuthRepository;
import org.rxjava.service.manager.repository.ManagerRepository;
import org.rxjava.service.manager.type.IdentityType;
import org.rxjava.service.starter.boot.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-27 00:03
 */
@RequestMapping("admin")
public class ManagerController {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ManagerAuthRepository managerAuthRepository;
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    /**
     * 管理员账号密码登陆
     */
    @Login(false)
    @PostMapping("login/password")
    public Mono<String> login(
            @Valid ManagerLoginForm form
    ) {
        String token = newToken();
        return managerAuthRepository
                .findByIdentityTypeAndIdentifierAndCredential(
                        IdentityType.USERNAME.name(),
                        form.getUsername(),
                        form.getPassword()
                )
                .flatMap(managerAuth -> reactiveRedisTemplate
                        .opsForValue()
                        .set(KeyUtils.newCacheId(ManagerController.class, token), managerAuth.getUserId())
                )
                .map(r -> token)
                .switchIfEmpty(ErrorMessageException.mono("用户不存在"));
    }

    /**
     * 查询管理员基本信息
     */
    @GetMapping("manager/info")
    public Mono<Manager> getManager(
            LoginInfo loginInfo
    ) {
        return managerRepository.findById(loginInfo.getUserId());
    }

    private String newToken() {
        return RandomStringUtils.random(32);
    }
}
