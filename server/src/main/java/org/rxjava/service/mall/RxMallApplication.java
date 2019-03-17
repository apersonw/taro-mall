package org.rxjava.service.mall;

import org.rxjava.service.mall.annotation.Account;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
@RestController
public class RxMallApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxMallApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

    @Account(false)
    @GetMapping("/")
    public Mono<String> system() {
        return Mono.just("商城服务正常");
    }
}
