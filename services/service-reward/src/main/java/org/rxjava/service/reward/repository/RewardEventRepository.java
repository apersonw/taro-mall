package org.rxjava.service.reward.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.reward.entity.RewardEvent;
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
public interface RewardEventRepository extends ReactiveSortingRepository<RewardEvent, String>, CustomizedRewardEventRepository {

}

interface CustomizedRewardEventRepository {
    Mono<Page<RewardEvent>> findPage(Pageable pageable);

    Mono<Void> patchStatusById(String rewardEventId, String sourceStatus, String targetStatus);

}

class CustomizedRewardEventRepositoryImpl implements CustomizedRewardEventRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<RewardEvent> pageAgent;

    @PostConstruct
    public void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, RewardEvent.class);
    }

    @Override
    public Mono<Page<RewardEvent>> findPage(Pageable pageable) {
        return pageAgent
                .findPage(new Query(),pageable);
    }

    @Override
    public Mono<Void> patchStatusById(String rewardId, String sourceStatus, String targetStatus) {
        Query query = Query.query(
                Criteria.where("id").is(rewardId)
                        .and("status").is(sourceStatus)
        );
        return reactiveMongoTemplate
                .findAndModify(query, Update.update("status", targetStatus), RewardEvent.class)
                .then();
    }
}