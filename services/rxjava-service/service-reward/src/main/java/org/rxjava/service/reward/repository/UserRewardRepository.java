package org.rxjava.service.reward.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.reward.entity.UserReward;
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
 * @author happy 2019-04-15 17:17
 */
@Repository
public interface UserRewardRepository extends ReactiveSortingRepository<UserReward, String>, CustomizedUserRewardRepository {

}

interface CustomizedUserRewardRepository {
    Mono<Page<UserReward>> findPage(Pageable pageable);
}

class CustomizedUserRewardRepositoryImpl implements CustomizedUserRewardRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<UserReward> pageAgent;

    @PostConstruct
    public void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, UserReward.class);
    }

    @Override
    public Mono<Page<UserReward>> findPage(Pageable pageable) {
        return pageAgent
                .findPage(new Query(), pageable);
    }
}