package org.rxjava.service.goods.services;

import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.form.GoodsCreateForm;
import org.rxjava.service.goods.form.GoodsListForm;
import org.rxjava.service.goods.form.GoodsPageForm;
import org.rxjava.service.goods.model.GoodsModel;
import org.rxjava.service.goods.repository.GoodsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author happy 2019-03-23 00:16
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    public Flux<GoodsModel> getListModel(GoodsListForm form) {
        return goodsRepository
                .getList(form)
                .map(this::transform);
    }

    public Mono<Page<Goods>> getPage(GoodsPageForm form) {
        return goodsRepository
                .getPage(form);
    }

    public Mono<GoodsModel> getByGoodsId(String goodsId) {
        return Mono
                .zip(
                        goodsRepository.getByGoodsId(goodsId),
                        goodsRepository.getCarouselImgList(goodsId).collectList().map(Optional::of).switchIfEmpty(Mono.just(Optional.empty())),
                        goodsRepository.getContentList(goodsId).collectList().map(Optional::of).switchIfEmpty(Mono.just(Optional.empty())),
                        goodsRepository.getSkuList(goodsId).collectList().map(Optional::of).switchIfEmpty(Mono.just(Optional.empty()))
                )
                .map(z -> {
                    GoodsModel model = this.transform(z.getT1());
                    z.getT2().ifPresent(model::setCarouselImgs);
                    z.getT3().ifPresent(model::setContents);
                    z.getT4().ifPresent(model::setSkus);
                    return model;
                });
    }

    private GoodsModel transform(Goods goods) {
        GoodsModel model = new GoodsModel();
        BeanUtils.copyProperties(goods, model);
        return model;
    }

    public Mono<Goods> create(GoodsCreateForm form) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(form, goods);
        return goodsRepository
                .save(goods);
    }
}
