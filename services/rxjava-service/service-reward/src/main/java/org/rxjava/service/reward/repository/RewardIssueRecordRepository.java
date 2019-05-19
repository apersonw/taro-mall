package org.rxjava.service.reward.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.reward.entity.RewardIssueRecord;
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
public interface RewardIssueRecordRepository extends ReactiveSortingRepository<RewardIssueRecord, String>, CustomizedRewardIssueRecordRepository {

}

interface CustomizedRewardIssueRecordRepository {
    Mono<Page<RewardIssueRecord>> findPage(Pageable pageable);
}

class CustomizedRewardIssueRecordRepositoryImpl implements CustomizedRewardIssueRecordRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<RewardIssueRecord> pageAgent;

    @PostConstruct
    public void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, RewardIssueRecord.class);
    }

    @Override
    public Mono<Page<RewardIssueRecord>> findPage(Pageable pageable) {
        return pageAgent
                .findPage(new Query(),pageable);
    }
}