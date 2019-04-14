package org.rxjava.service.goods.repository;

import org.rxjava.service.goods.entity.Brand;
import org.rxjava.service.goods.form.BrandListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface BrandRepository extends ReactiveSortingRepository<Brand, String>, SpecialBrandRepository {

}

interface SpecialBrandRepository {
    Flux<Brand> getList(BrandListForm form);
}

class SpecialBrandRepositoryImpl implements SpecialBrandRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<Brand> getList(BrandListForm form) {
        return null;
    }
}