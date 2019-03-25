package org.rxjava.service.mall.person;

import org.rxjava.service.mall.model.BrandModel;
import org.rxjava.service.mall.form.BrandQueryForm;
import org.rxjava.service.mall.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

/**
 * @author happy 2019-03-25 23:03
 */
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("brands")
    public Flux<BrandModel> getList(
            @Valid BrandQueryForm form
    ) {
        return brandService
                .getList(form);

    }
}
