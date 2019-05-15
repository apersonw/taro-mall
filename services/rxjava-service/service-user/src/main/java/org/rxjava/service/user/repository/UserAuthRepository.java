package org.rxjava.service.user.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.user.entity.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface UserAuthRepository extends ReactiveSortingRepository<UserAuth, String>, SpecialUserAuthRepository {
    Mono<UserAuth> findByIdentityTypeAndIdentifier(String identityType, String identifier);
}

interface SpecialUserAuthRepository {
    Mono<Void> updateUserIdById(String userAuthId, String userId);
}

class SpecialUserAuthRepositoryImpl implements SpecialUserAuthRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<UserAuth> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, UserAuth.class);
    }

    @Override
    public Mono<Void> updateUserIdById(String userAuthId, String userId) {
        Query query = Query.query(Criteria.where("id").is(userAuthId).and("userId").is(null));
        return reactiveMongoTemplate
                .findAndModify(query, Update.update("userId", userId), UserAuth.class)
                .then();
    }
}