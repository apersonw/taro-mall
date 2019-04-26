package org.rxjava.service.manager.repository;

import org.rxjava.service.manager.entity.ManagerAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-04-27 00:13
 */
@Repository
public interface ManagerAuthRepository extends ReactiveSortingRepository<ManagerAuth, String>, SpecialManagerAuthRepository {
    Mono<ManagerAuth> findByIdentityTypeAndIdentifierAndCredential(String identityType, String identifier, String credential);
}

interface SpecialManagerAuthRepository {

}

class SpecialManagerAuthRepositoryImpl implements SpecialManagerAuthRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
}