package org.rxjava.service.goods.admin;

import org.rxjava.common.core.annotation.Login;
import org.rxjava.service.goods.entity.Brand;
import org.rxjava.service.goods.form.BrandPageForm;
import org.rxjava.service.goods.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-28 22:44
 */
@RestController
@RequestMapping("admin")
public class AdminBrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 品牌分页
     */
    @Login(false)
    @GetMapping("brandPage")
    public Mono<Page<Brand>> getPage(
            @Valid BrandPageForm form
    ) {
        return brandService
                .getPage(PageRequest.of(form.getPage(), form.getPageSize()), form);
    }
}
