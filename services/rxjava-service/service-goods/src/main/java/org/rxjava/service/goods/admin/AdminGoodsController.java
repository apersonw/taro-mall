package org.rxjava.service.goods.admin;

import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.form.GoodsCreateForm;
import org.rxjava.service.goods.form.GoodsPageForm;
import org.rxjava.service.goods.repository.GoodsRepository;
import org.rxjava.service.goods.services.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 创建商品
     */
    @PostMapping("goods")
    public Mono<Goods> save(GoodsCreateForm form) {
        return Mono.justOrEmpty(form.getId())
                .flatMap(id -> goodsRepository.findById(id))
                .switchIfEmpty(Mono.just(new Goods()).map(goods -> {
                    goods.setId(null);
                    return goods;
                }))
                .map(goods -> {
                    BeanUtils.copyProperties(form, goods);
                    return goods;
                })
                .flatMap(goodsRepository::save);
    }

    /**
     * 商品分页
     */
    @GetMapping("goodsPage")
    public Mono<Page<Goods>> getPage(
            @Valid GoodsPageForm form
    ) {
        return goodsService
                .getPage(PageRequest.of(form.getPage(), form.getPageSize()), form);
    }
}
