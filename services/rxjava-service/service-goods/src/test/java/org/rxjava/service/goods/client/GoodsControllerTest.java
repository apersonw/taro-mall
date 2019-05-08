package org.rxjava.service.goods.client;

import org.junit.Test;
import org.rxjava.common.test.BaseContext;
import org.rxjava.service.goods.model.GoodsModel;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

/**
 * @author happy 2019-05-08 21:30
 */
public class GoodsControllerTest extends BaseContext {

    @Test
    public void getList() {
        Mono<List<GoodsModel>> listMono = WebClient
                .create("http://localhost:8082")
                .get()
                .uri("goodsList/0-10")
                .retrieve()
                .bodyToFlux(GoodsModel.class)
                .collectList();

        StepVerifier
                .create(listMono)
                .assertNext(List::size)
                .verifyComplete();
    }
}
