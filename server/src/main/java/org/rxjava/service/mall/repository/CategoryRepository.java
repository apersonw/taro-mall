package org.rxjava.service.mall.repository;

import org.rxjava.service.mall.entity.Category;
import org.rxjava.service.mall.form.CategoryQueryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-23 00:17
 */
@Repository
public interface CategoryRepository extends ReactiveSortingRepository<Category, String>, SpecialCategoryRepository {

}

interface SpecialCategoryRepository {
    Flux<Category> getList(CategoryQueryForm form);
}

class SpecialCategoryRepositoryImpl implements SpecialCategoryRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<Category> getList(CategoryQueryForm form) {
        return null;
    }
}
