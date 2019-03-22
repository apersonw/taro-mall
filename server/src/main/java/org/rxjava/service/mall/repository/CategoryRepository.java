package org.rxjava.service.mall.repository;

import org.rxjava.service.mall.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author happy 2019-03-23 00:17
 */
@Repository
public interface CategoryRepository extends ReactiveSortingRepository<Category, String>, SpecialGoodsRepository {
}

interface SpecialCategoryRepository {
}

class SpecialCategoryRepositoryImpl implements SpecialCategoryRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
}
