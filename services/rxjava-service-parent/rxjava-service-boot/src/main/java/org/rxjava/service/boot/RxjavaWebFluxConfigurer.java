package org.rxjava.service.boot;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author happy 2019-04-14 00:41
 */
@Configuration
@EnableRetry
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class RxjavaWebFluxConfigurer implements WebFluxConfigurer {

    @Bean
    @Primary
    ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
    }
}
