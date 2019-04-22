package org.rxjava.gateway.manager;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class RxManagerGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxManagerGatewayApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

    @GetMapping("/")
    public Mono<String> system() {
        return Mono.just("管理网关正常");
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/goods/**").filters(p -> p.stripPrefix(1)).uri("lb://service-goods/"))
                .build();
    }
}
