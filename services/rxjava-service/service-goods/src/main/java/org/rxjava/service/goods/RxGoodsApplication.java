package org.rxjava.service.goods;

import org.rxjava.api.user.serve.ServeUserApi;
import org.rxjava.apikit.client.ClientAdapter;
import org.rxjava.common.core.annotation.Login;
import org.rxjava.service.starter.ReactiveHttpClientAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
@RestController
public class RxGoodsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxGoodsApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

    @Login(false)
    @GetMapping("/")
    public Mono<String> system() {
        return Mono.just("商品服务正常");
    }

    @Bean
    @Qualifier("userClientAdapter")
    public ClientAdapter userClientAdapter(
            @Qualifier("webFluxConversionService")
                    ConversionService conversionService,
            WebClient.Builder webClientBuilder
    ) {
        return ReactiveHttpClientAdapter.build(
                conversionService, webClientBuilder, "service-user"
        );
    }

    @Bean
    public ServeUserApi serveUserApi(@Qualifier("userClientAdapter") ClientAdapter clientAdapter) {
        ServeUserApi serveUserApi = new ServeUserApi();
        serveUserApi.setclientAdapter(clientAdapter);
        return serveUserApi;
    }

}
