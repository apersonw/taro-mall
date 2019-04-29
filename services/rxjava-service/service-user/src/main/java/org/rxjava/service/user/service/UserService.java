package org.rxjava.service.user.service;

import org.rxjava.service.user.entity.User;
import org.rxjava.service.user.form.UserPageForm;
import org.rxjava.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-04-22 20:20
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Mono<Page<User>> findPage(UserPageForm form, Pageable pageable) {
        return userRepository
                .findPage(form, pageable);
    }
}
