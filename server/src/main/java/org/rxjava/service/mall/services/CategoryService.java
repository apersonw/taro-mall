package org.rxjava.service.mall.services;

import org.rxjava.service.mall.entity.Brand;
import org.rxjava.service.mall.entity.Category;
import org.rxjava.service.mall.form.CategoryQueryForm;
import org.rxjava.service.mall.model.BrandModel;
import org.rxjava.service.mall.model.CategoryModel;
import org.rxjava.service.mall.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author happy 2019-03-25 23:14
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryModel transform(Category entity) {
        CategoryModel model = new CategoryModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    public Flux<CategoryModel> getList(CategoryQueryForm form) {
        return categoryRepository
                .getList(form)
                .map(this::transform);
    }
}
