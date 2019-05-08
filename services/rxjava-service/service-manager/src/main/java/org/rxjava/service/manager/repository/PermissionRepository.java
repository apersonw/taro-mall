package org.rxjava.service.manager.repository;

import org.rxjava.service.manager.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author happy 2019-04-27 00:13
 */
@Repository
public interface PermissionRepository extends ReactiveSortingRepository<Permission, String>, SpecialPermissionRepository {
}

interface SpecialPermissionRepository {

}

class SpecialPermissionRepositoryImpl implements SpecialPermissionRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
}