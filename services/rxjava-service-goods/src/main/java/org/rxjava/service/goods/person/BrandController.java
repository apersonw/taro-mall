package org.rxjava.service.goods.person;

import org.rxjava.service.goods.form.BrandListForm;
import org.rxjava.service.goods.model.BrandModel;
import org.rxjava.service.goods.services.BrandService;
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
            @Valid BrandListForm form
    ) {
        return brandService
                .getList(form);

    }
}
