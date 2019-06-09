package org.rxjava.service.goods.person;

import org.rxjava.api.user.inner.InnerUserApi;
import org.rxjava.api.user.inner.entity.User;
import org.rxjava.common.core.annotation.Login;
import org.rxjava.service.goods.form.GoodsListForm;
import org.rxjava.service.goods.model.GoodsModel;
import org.rxjava.service.goods.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    @Autowired
    private InnerUserApi innerUserApi;

    @Login(false)
    @GetMapping("testInnerUserApi")
    public Mono<User> testInnerUserApi() {
        return innerUserApi.tokenToUser("hello");
    }

    /**
     * 商品列表
     */
    @Login(false)
    @GetMapping("goodsList/{page}-{pageSize}")
    public Flux<GoodsModel> getList(
            @PathVariable int page,
            @PathVariable int pageSize,
            @Valid GoodsListForm form
    ) {
        return goodsService
                .getListModel(PageRequest.of(page, pageSize), form);
    }

    /**
     * 查询商品
     */
    @Login(false)
    @GetMapping("goods/{goodsId}")
    public Mono<GoodsModel> getByGoodsId(
            @PathVariable String goodsId
    ) {
        return goodsService
                .findGoods(goodsId);
    }
}
