package org.rxjava.service.goods.repository;

import org.rxjava.service.goods.entity.Shop;
import org.rxjava.service.goods.form.ShopListForm;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author happy 2019-03-25 23:06
 */
@Repository
public interface ShopRepository extends ReactiveSortingRepository<Shop, String>, SpecialShopRepository {

}

interface SpecialShopRepository {
    Flux<Shop> getList(ShopListForm form);
}

class SpecialShopRepositoryImpl implements SpecialShopRepository {

    @Override
    public Flux<Shop> getList(ShopListForm form) {
        return null;
    }
}