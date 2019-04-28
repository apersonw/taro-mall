package org.rxjava.service.goods.repository;

import org.rxjava.common.core.mongo.PageAgent;
import org.rxjava.service.goods.entity.Brand;
import org.rxjava.service.goods.form.BrandListForm;
import org.rxjava.service.goods.form.BrandPageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface BrandRepository extends ReactiveSortingRepository<Brand, String>, SpecialBrandRepository {

}

interface SpecialBrandRepository {
    Flux<Brand> getList(BrandListForm form);

    Mono<Page<Brand>> findPage(Pageable pageable, BrandPageForm form);
}

class SpecialBrandRepositoryImpl implements SpecialBrandRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private PageAgent<Brand> pageAgent;

    @PostConstruct
    private void init() {
        pageAgent = new PageAgent<>(reactiveMongoTemplate, Brand.class);
    }

    @Override
    public Flux<Brand> getList(BrandListForm form) {
        return null;
    }

    @Override
    public Mono<Page<Brand>> findPage(Pageable pageable, BrandPageForm form) {
        Query query = new Query();
        query.with(pageable);
        return pageAgent.findPage(query, pageable);
    }
}