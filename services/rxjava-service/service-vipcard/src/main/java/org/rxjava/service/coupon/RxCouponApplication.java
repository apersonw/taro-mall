package org.rxjava.service.coupon;

import org.rxjava.common.core.annotation.Login;
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
public class RxCouponApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxCouponApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

    @Login(false)
    @GetMapping("/")
    public Mono<String> system() {
        return Mono.just("商品服务正常");
    }
}
