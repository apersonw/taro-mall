package org.rxjava.service.link.repository;

import org.rxjava.service.link.entity.LinkLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface LinkLocationRepository extends ReactiveSortingRepository<LinkLocation, String>, SpecialLinkLocationRepository {

}

interface SpecialLinkLocationRepository {
    Mono<Page<LinkLocation>> findPage();
}

class SpecialLinkLocationRepositoryImpl implements SpecialLinkLocationRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Page<LinkLocation>> findPage() {
        return null;
    }
}