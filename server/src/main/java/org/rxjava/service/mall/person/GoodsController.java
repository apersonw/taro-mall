package org.rxjava.service.mall.person;

import org.rxjava.service.mall.annotation.Account;
import org.rxjava.service.mall.form.GoodsQueryForm;
import org.rxjava.service.mall.model.GoodsModel;
import org.rxjava.service.mall.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-03-17 23:27
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 商品列表
     */
    @Account(false)
    @GetMapping("goodsList")
    public Flux<GoodsModel> getList(
            @Valid GoodsQueryForm form
    ) {
        return goodsService
                .getList(form);
    }

    /**
     * 查询商品
     */
    @Account(false)
    @GetMapping("goods/{goodsId}")
    public Mono<GoodsModel> getByGoodsId(
            @PathVariable String goodsId
    ) {
        return goodsService
                .getByGoodsId(goodsId);
    }
}
