package org.rxjava.service.goods.services;

import org.rxjava.service.goods.entity.User;
import org.rxjava.service.goods.form.UserCreateForm;
import org.rxjava.service.goods.form.UserListForm;
import org.rxjava.service.goods.model.UserModel;
import org.rxjava.service.goods.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-21 23:17
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<UserModel> create(UserCreateForm form) {
        User user = new User();
        BeanUtils.copyProperties(form, user);
        return userRepository
                .save(user)
                .onErrorResume(DuplicateKeyException.class, t -> Mono.error(new RuntimeException("账号/手机/邮箱已注册")))
                .map(this::transform);
    }

    public Flux<UserModel> getList(UserListForm form) {
        return userRepository
                .getList(form)
                .map(this::transform);
    }

    private UserModel transform(User user) {
        UserModel model = new UserModel();
        BeanUtils.copyProperties(user, model);
        return model;
    }
}
