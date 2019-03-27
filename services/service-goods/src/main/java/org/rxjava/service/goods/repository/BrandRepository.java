package org.rxjava.service.goods.repository;

import org.rxjava.service.goods.entity.Brand;
import org.rxjava.service.goods.form.BrandQueryForm;
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
    Flux<Brand> getList(BrandQueryForm form);
}

class SpecialBrandRepositoryImpl implements SpecialBrandRepository {

    @Override
    public Flux<Brand> getList(BrandQueryForm form) {
        return null;
    }
}