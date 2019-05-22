package org.rxjava.service.user.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.user.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface LoginLogRepository extends ReactiveSortingRepository<LoginLog, String>, SpecialLoginLogRepository {

}

interface SpecialLoginLogRepository {
}

class SpecialLoginLogRepositoryImpl implements SpecialLoginLogRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<LoginLog> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, LoginLog.class);
    }
}