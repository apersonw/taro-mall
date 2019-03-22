package org.rxjava.service.mall.repository;

import org.rxjava.service.mall.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author happy 2019-03-23 00:17
 */
@Repository
public interface ResourceRepository extends ReactiveSortingRepository<Resource, String>, SpecialGoodsRepository {
}

interface SpecialResourceRepository {
}

class SpecialResourceRepositoryImpl implements SpecialResourceRepository {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
}
