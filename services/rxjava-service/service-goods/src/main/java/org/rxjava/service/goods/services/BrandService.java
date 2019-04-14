package org.rxjava.service.goods.services;

import org.rxjava.service.goods.entity.Brand;
import org.rxjava.service.goods.form.BrandListForm;
import org.rxjava.service.goods.model.BrandModel;
import org.rxjava.service.goods.repository.BrandRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author happy 2019-03-25 23:06
 */
@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Flux<BrandModel> getList(BrandListForm form) {
        return brandRepository
                .getList(form)
                .map(this::transform);
    }

    private BrandModel transform(Brand brand) {
        BrandModel model = new BrandModel();
        BeanUtils.copyProperties(brand, model);
        return model;
    }
}
