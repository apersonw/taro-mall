package org.rxjava.service.manager.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.manager.entity.Manager;
import org.rxjava.service.manager.form.ManagerPageForm;
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
 * @author happy 2019-04-27 00:13
 */
@Repository
public interface ManagerRepository extends ReactiveSortingRepository<Manager, String>, SpecialManagerRepository {
}

interface SpecialManagerRepository {
    Mono<Page<Manager>> findPage(Pageable pageable, ManagerPageForm form);
}

class SpecialManagerRepositoryImpl implements SpecialManagerRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
    private PageAgent<Manager> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, Manager.class);
    }

    @Override
    public Mono<Page<Manager>> findPage(Pageable pageable, ManagerPageForm form) {
        Query query = new Query();
        return pageAgent
                .findPage(query, pageable);
    }
}