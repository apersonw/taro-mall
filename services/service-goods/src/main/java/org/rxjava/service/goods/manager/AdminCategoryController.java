package org.rxjava.service.goods.manager;

import org.rxjava.service.goods.entity.Category;
import org.rxjava.service.goods.form.CategoryPageQueryForm;
import org.rxjava.service.goods.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-03-27 02:30
 */
@RestController
@RequestMapping("admin")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("categories")
    public Mono<Page<Category>> getPage(
            @Valid CategoryPageQueryForm form
    ) {
        return categoryService
                .getPage(form);
    }
}
