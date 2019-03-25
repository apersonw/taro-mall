package org.rxjava.service.mall.services;

import org.rxjava.service.mall.entity.Brand;
import org.rxjava.service.mall.form.BrandQueryForm;
import org.rxjava.service.mall.model.BrandModel;
import org.rxjava.service.mall.repository.BrandRepository;
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

    public Flux<BrandModel> getList(BrandQueryForm form) {
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
