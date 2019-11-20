package org.rxjava.service.goods.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.TextNode;
import org.rxjava.common.bus.BusEmitter;
import org.rxjava.common.bus.BusEvent;
import org.rxjava.common.bus.BusEventType;
import org.rxjava.common.core.annotation.Login;
import org.rxjava.service.goods.form.GoodsListForm;
import org.rxjava.service.goods.model.GoodsModel;
import org.rxjava.service.goods.model.SkuAndGroupModel;
import org.rxjava.service.goods.services.GoodsService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author happy 2019-03-17 23:27
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BusEmitter busEmitter;

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

    /**
     * 列表：商品Sku列表及分组
     */
    @Login(false)
    @GetMapping("goods/{goodsId}/skuList")
    public Mono<SkuAndGroupModel> getSkuListByGoodsId(
            @PathVariable String goodsId
    ) {
        return goodsService.findSkuAndGroup(goodsId);
    }

    /**
     * 购买商品
     */
    @GetMapping("goods/{goodsId}/sku/{skuId}")
    public Mono<String> buyGoods(
            @PathVariable String goodsId,
            @PathVariable String skuId
    ) {
        return goodsService.buyGoods(goodsId, skuId);
    }

    @GetMapping("testBus")
    public Mono<String> testBus() {
        System.out.println(LocalDateTime.now());
        busEmitter.delayEmit(BusEventType.ORDER_CANCEL_START, new TextNode("测试死信消息队列"), 10).subscribe();
        return Mono.justOrEmpty("测试死信队列");
    }

}
