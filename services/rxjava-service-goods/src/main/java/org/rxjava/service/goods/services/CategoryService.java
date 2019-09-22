package org.rxjava.service.goods.services;

import org.rxjava.service.goods.entity.Category;
import org.rxjava.service.goods.form.CategoryPageForm;
import org.rxjava.service.goods.model.CategoryModel;
import org.rxjava.service.goods.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-25 23:14
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Flux<CategoryModel> getList(String parentId) {
        return categoryRepository
                .getList(parentId)
                .map(this::transform);
    }

    private CategoryModel transform(Category entity) {
        CategoryModel model = new CategoryModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    public Mono<Page<Category>> getPage(Pageable pageable, CategoryPageForm form) {
        return categoryRepository
                .findPage(pageable, form);
    }
}
