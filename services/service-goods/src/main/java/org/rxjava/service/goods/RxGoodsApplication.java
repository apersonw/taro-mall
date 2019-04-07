package org.rxjava.service.goods;

import org.rxjava.service.goods.annotation.Account;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
@RestController
@EnableMongoAuditing
public class RxGoodsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxGoodsApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

    @Account(false)
    @GetMapping("/")
    public Mono<String> system() {
        return Mono.just("商品服务正常");
    }
}
