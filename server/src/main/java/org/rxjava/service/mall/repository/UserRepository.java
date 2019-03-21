package org.rxjava.service.mall.repository;

import org.rxjava.service.mall.entity.User;
import org.rxjava.service.mall.form.UserListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author happy 2019-03-21 23:01
 */
@Repository
public interface UserRepository extends ReactiveSortingRepository<User, String>, SpecialUserRepository {
}

interface SpecialUserRepository {
    Flux<User> getList(UserListForm form);
}

class SpecialUserRepositoryImpl implements SpecialUserRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<User> getList(UserListForm form) {
        return reactiveMongoTemplate
                .find(new Query().with(PageRequest.of(form.getPage(), form.getPageSize())), User.class);
    }
}