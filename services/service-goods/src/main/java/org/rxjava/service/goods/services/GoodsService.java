package org.rxjava.service.goods.services;

import org.rxjava.service.goods.entity.Goods;
import org.rxjava.service.goods.form.GoodsQueryForm;
import org.rxjava.service.goods.model.GoodsModel;
import org.rxjava.service.goods.repository.GoodsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-23 00:16
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    public Flux<GoodsModel> getList(GoodsQueryForm form) {
        return goodsRepository
                .getList(form)
                .map(this::transform);
    }

    private GoodsModel transform(Goods goods) {
        GoodsModel model = new GoodsModel();
        BeanUtils.copyProperties(goods, model);
        return model;
    }

    public Mono<GoodsModel> getByGoodsId(String goodsId) {
        return goodsRepository
                .getByGoodsId(goodsId)
                .map(this::transform);
    }
}
