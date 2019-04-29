package org.rxjava.service.user.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.user.entity.User;
import org.rxjava.service.user.form.UserPageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface UserRepository extends ReactiveSortingRepository<User, String>, SpecialUserRepository {

}

interface SpecialUserRepository {
    Mono<Page<User>> findPage(UserPageForm form, Pageable pageable);
}

class SpecialUserRepositoryImpl implements SpecialUserRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<User> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, User.class);
    }

    @Override
    public Mono<Page<User>> findPage(UserPageForm form, Pageable pageable) {
        Query query = new Query();
        return pageAgent.findPage(query, pageable);
    }
}