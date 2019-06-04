package org.rxjava.service.goods.admin;

import org.rxjava.common.core.annotation.Login;
import org.rxjava.service.goods.entity.Category;
import org.rxjava.service.goods.form.CategoryPageForm;
import org.rxjava.service.goods.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-28 22:40
 */
@RestController
@RequestMapping("admin")
public class AdminCategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 分类分页
     */
    @Login(false)
    @GetMapping("categoryPage")
    public Mono<Page<Category>> getPage(
            @Valid CategoryPageForm form
    ) {
        return categoryService
                .getPage(PageRequest.of(form.getPage(), form.getPageSize()), form);
    }
}
