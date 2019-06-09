package org.rxjava.service.link.repository;

import org.rxjava.service.link.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface LinkRepository extends ReactiveSortingRepository<Link, String>, SpecialLinkRepository {

}

interface SpecialLinkRepository {
}

class SpecialLinkRepositoryImpl implements SpecialLinkRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
}