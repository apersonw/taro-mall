package org.rxjava.service.goods.repository;

import org.rxjava.service.goods.entity.Spike;
import org.rxjava.service.goods.form.SpikeListForm;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface SpikeRepository extends ReactiveSortingRepository<Spike, String>, SpecialSpikeRepository {

}

interface SpecialSpikeRepository {
    Flux<Spike> getList(SpikeListForm form);
}

class SpecialSpikeRepositoryImpl implements SpecialSpikeRepository {

    @Override
    public Flux<Spike> getList(SpikeListForm form) {
        return null;
    }
}