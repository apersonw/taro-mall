package org.rxjava.service.link.repository;

import org.rxjava.service.link.entity.LinkLocation;
import org.rxjava.service.link.form.LinkLocationPageForm;
import org.rxjava.service.starter.mongo.PageAgent;
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
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface LinkLocationRepository extends ReactiveSortingRepository<LinkLocation, String>, SpecialLinkLocationRepository {

}

interface SpecialLinkLocationRepository {

    Mono<Page<LinkLocation>> findPage(LinkLocationPageForm form, Pageable pageable);
}

class SpecialLinkLocationRepositoryImpl implements SpecialLinkLocationRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
    private PageAgent<LinkLocation> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, LinkLocation.class);
    }

    @Override
    public Mono<Page<LinkLocation>> findPage(LinkLocationPageForm form, Pageable pageable) {
        Query query = new Query();
        return pageAgent.findPage(query, pageable);
    }
}