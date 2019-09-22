package org.rxjava.service.goods.admin;

import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.form.GoodsCreateForm;
import org.rxjava.service.goods.form.GoodsPageForm;
import org.rxjava.service.goods.repository.GoodsRepository;
import org.rxjava.service.goods.services.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-03-27 02:30
 * 管理商品
 */
@RestController
@RequestMapping("admin")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 保存
     */
    @PostMapping("goods")
    public Mono<Goods> save(GoodsCreateForm form) {
        return Mono.justOrEmpty(form.getId())
                .flatMap(id -> goodsRepository.findById(id))
                .switchIfEmpty(Mono.just(new Goods()).map(goods -> {
                    //将form的id置null
                    form.setId(null);
                    return goods;
                }))
                .map(goods -> {
                    BeanUtils.copyProperties(form, goods);
                    return goods;
                })
                .flatMap(goodsRepository::save);
    }

    /**
     * 分页
     */
    @GetMapping("goodsPage")
    public Mono<Page<Goods>> getPage(
            @Valid GoodsPageForm form
    ) {
        return goodsService
                .getPage(form);
    }

    /**
     * 详情
     */
    @GetMapping("goods/{goodsId}")
    public Mono<Goods> getByGoodsId(
            @PathVariable String goodsId
    ) {
        return goodsService
                .findGoods(goodsId);
    }

    /**
     * 删除
     */
    @DeleteMapping("goods/{goodsId}")
    public Mono<Void> deleteByGoodsId(
            @PathVariable String goodsId
    ) {
        return goodsService
                .deleteByGoodsId(goodsId);
    }
}
