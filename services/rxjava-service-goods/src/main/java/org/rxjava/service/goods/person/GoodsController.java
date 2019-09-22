package org.rxjava.service.goods.person;

import org.rxjava.common.core.annotation.Login;
import org.rxjava.service.goods.form.GoodsListForm;
import org.rxjava.service.goods.model.GoodsModel;
import org.rxjava.service.goods.services.GoodsService;
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
     * 列表：商品
     */
    @Login(false)
    @GetMapping("goodsList")
    public Flux<GoodsModel> getList(@Valid GoodsListForm form) {
        return goodsService
                .getListModel(form);
    }

    /**
     * 详情：商品
     */
    @Login(false)
    @GetMapping("goods/{goodsId}")
    public Mono<GoodsModel> getByGoodsId(
            @PathVariable String goodsId
    ) {
        return goodsService
                .findGoodsModel(goodsId);
    }
}
