package org.rxjava.service.manager.repository;

import org.rxjava.service.manager.entity.ManagerRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author happy 2019-04-27 00:13
 */
@Repository
public interface ManagerRoleRepository extends ReactiveSortingRepository<ManagerRole, String>, SpecialManagerRoleRepository {
}

interface SpecialManagerRoleRepository {
}

class SpecialManagerRoleRepositoryImpl implements SpecialManagerRoleRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
}