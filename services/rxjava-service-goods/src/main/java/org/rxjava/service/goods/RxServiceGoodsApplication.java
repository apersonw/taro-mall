package org.rxjava.service.goods;

import org.rxjava.api.user.inner.InnerUserApi;
import org.rxjava.apikit.client.ClientAdapter;
import org.rxjava.common.core.api.ReactiveHttpClientAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
public class RxServiceGoodsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxServiceGoodsApplication.class).web(WebApplicationType.REACTIVE).run(args);
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
    public InnerUserApi innerUserApi(@Qualifier("userClientAdapter") ClientAdapter clientAdapter) {
        InnerUserApi innerUserApi = new InnerUserApi();
        innerUserApi.setclientAdapter(clientAdapter);
        return innerUserApi;
    }

}
