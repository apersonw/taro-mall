package org.rxjava.service.goods.services;

import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.entity.Sku;
import org.rxjava.service.goods.form.GoodsCreateForm;
import org.rxjava.service.goods.form.GoodsListForm;
import org.rxjava.service.goods.form.GoodsPageForm;
import org.rxjava.service.goods.model.GoodsModel;
import org.rxjava.service.goods.model.SkuModel;
import org.rxjava.service.goods.repository.GoodsRepository;
import org.rxjava.service.goods.repository.SkuRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-23 00:16
 * 商品服务
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private SkuRepository skuRepository;

    /**
     * Model：列表
     */
    public Flux<GoodsModel> getListModel(GoodsListForm form) {
        return goodsRepository
                .getList(PageRequest.of(form.getPage(), form.getPageSize()), form)
                .map(this::castToModel);
    }

    /**
     * Entity：分页
     */
    public Mono<Page<Goods>> getPage(GoodsPageForm form) {
        return goodsRepository
                .findPage(PageRequest.of(form.getPage(), form.getPageSize()), form);
    }

    public Mono<Goods> create(GoodsCreateForm form) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(form, goods);
        return goodsRepository
                .save(goods);
    }

    public Mono<GoodsModel> findGoodsModel(String goodsId) {
        return this.findGoods(goodsId)
                .map(this::castToModel);
    }

    public Mono<Goods> findGoods(String goodsId) {
        return goodsRepository.findById(goodsId);
    }

    /**
     * 转为Model
     */
    private GoodsModel castToModel(Goods goods) {
        GoodsModel model = new GoodsModel();
        BeanUtils.copyProperties(goods, model);
        return model;
    }

    private Flux<SkuModel> findSkus(String goodsId) {
        return skuRepository
                .findByGoodsId(goodsId)
                .map(this::transformSku);
    }

    private SkuModel transformSku(Sku sku) {
        SkuModel model = new SkuModel();
        BeanUtils.copyProperties(sku, model);
        return model;
    }

    public Mono<Void> deleteByGoodsId(String goodsId) {
        return goodsRepository
                .deleteById(goodsId);
    }
}
