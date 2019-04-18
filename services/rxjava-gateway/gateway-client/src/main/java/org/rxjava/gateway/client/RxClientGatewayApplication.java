package org.rxjava.gateway.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-03-17 22:10
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
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
}