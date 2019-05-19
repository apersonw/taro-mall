package org.rxjava.gateway.client;

import org.rxjava.api.user.serve.ServeUserApi;
import org.rxjava.apikit.client.ClientAdapter;
import org.rxjava.common.core.api.ReactiveHttpClientAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-17 22:10
 */
@RestController
@SpringBootApplication
public class RxClientGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxClientGatewayApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

    @GetMapping("/")
    public Mono<String> system() {
        return Mono.just("客户端网关正常");
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/user/**").filters(p -> p.stripPrefix(1)).uri("lb://service-user"))
                .route(r -> r.path("/goods/**").filters(p -> p.stripPrefix(1)).uri("lb://service-goods"))
                .route(r -> r.path("/order/**").filters(p -> p.stripPrefix(1)).uri("lb://service-order"))
                .route(r -> r.path("/pay/**").filters(p -> p.stripPrefix(1)).uri("lb://service-pay"))
                .build();
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

    @Bean
    public TokenFilter tokenFilter(ServeUserApi serveUserApi) {
        return new TokenFilter(serveUserApi);
    }
}