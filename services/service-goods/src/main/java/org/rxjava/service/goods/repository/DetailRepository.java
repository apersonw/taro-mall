package org.rxjava.service.goods.repository;

import org.rxjava.service.goods.entity.Detail;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface DetailRepository extends ReactiveSortingRepository<Detail, String>, SpecialDetailRepository {

}

interface SpecialDetailRepository {
}

class SpecialDetailRepositoryImpl implements SpecialDetailRepository {
}