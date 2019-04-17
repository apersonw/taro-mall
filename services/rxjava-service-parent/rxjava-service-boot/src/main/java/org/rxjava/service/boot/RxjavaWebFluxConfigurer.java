package org.rxjava.service.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rxjava.service.boot.utils.JsonUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.List;

/**
 * @author happy 2019-04-14 00:41
 */
@Configuration
@Import({
        SecurityDelegatingWebFluxConfiguration.class,
})
@EnableRetry
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class RxjavaWebFluxConfigurer implements WebFluxConfigurer {

    @Bean
    @Primary
    ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return JsonUtils.create();
    }

    @Bean
    Jackson2JsonEncoder jackson2JsonEncoder(ObjectMapper mapper) {
        return new Jackson2JsonEncoder(mapper);
    }

    @Bean
    Jackson2JsonDecoder jackson2JsonDecoder(ObjectMapper mapper) {
        return new Jackson2JsonDecoder(mapper);
    }

    /**
     * 配置http消息编解码
     */
    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        configurer.defaultCodecs().jackson2JsonEncoder(jackson2JsonEncoder(objectMapper()));
        configurer.defaultCodecs().jackson2JsonDecoder(jackson2JsonDecoder(objectMapper()));
    }
}
