package org.rxjava.service.manager.repository;

import org.rxjava.service.manager.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author happy 2019-04-27 00:13
 */
@Repository
public interface ManagerRepository extends ReactiveSortingRepository<Manager, String>, SpecialManagerRepository {
}

interface SpecialManagerRepository {

}

class SpecialManagerRepositoryImpl implements SpecialManagerRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
}