package org.rxjava.service.reward.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.reward.entity.Reward;
import org.rxjava.service.reward.status.RewardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @author happy 2019-04-15 17:17
 */
@Repository
public interface RewardRepository extends ReactiveSortingRepository<Reward, String>, CustomizedRewardRepository {

}

interface CustomizedRewardRepository {
    Mono<Page<Reward>> findPage(Pageable pageable);

    Mono<Void> patchStatusById(String rewardId, String sourceStatus, String targetStatus);

    Mono<Reward> findValidById(String id);
}

class CustomizedRewardRepositoryImpl implements CustomizedRewardRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<Reward> mongoPageAgent;

    @PostConstruct
    public void init() {
        mongoPageAgent = new PageAgent<>(reactiveMongoTemplate, Reward.class);
    }

    @Override
    public Mono<Page<Reward>> findPage(Pageable pageable) {
        return mongoPageAgent
                .findPage(new Query(),pageable);
    }

    @Override
    public Mono<Void> patchStatusById(String rewardId, String sourceStatus, String targetStatus) {
        Query query = Query.query(
                Criteria.where("id").is(rewardId)
                        .and("status").is(sourceStatus)
        );
        return reactiveMongoTemplate
                .findAndModify(query, Update.update("status", targetStatus), Reward.class)
                .then();
    }

    @Override
    public Mono<Reward> findValidById(String id) {
        Criteria where = Criteria.where("id").is(id).and("status").is(RewardStatus.NORMAL.name());
        return reactiveMongoTemplate
                .findOne(Query.query(where), Reward.class);
    }
}