package org.rxjava.service.goods.dashboard;

import org.rxjava.service.goods.annotation.Account;
import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.form.GoodsCreateForm;
import org.rxjava.service.goods.form.GoodsPageForm;
import org.rxjava.service.goods.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-03-27 02:30
 */
@RestController
@RequestMapping("admin")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 创建商品
     */
    @Account(false)
    @PostMapping("goods")
    public Mono<Goods> create(GoodsCreateForm form) {
        return goodsService
                .create(form);
    }

    /**
     * 商品列表
     */
    @Account(false)
    @GetMapping("goodsList")
    public Mono<Page<Goods>> getList(
            @Valid GoodsPageForm form
    ) {
        return goodsService
                .getPage(form);
    }
}
