package org.rxjava.service.starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rxjava.common.core.utils.JsonUtils;
import org.rxjava.service.starter.boot.RxjavaDelegatingWebFluxConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author happy 2019-04-09 01:32
 * 响应式服务自动配置starter
 */
@Configuration
@Import({RxjavaDelegatingWebFluxConfiguration.class})
@EnableDiscoveryClient
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class RxJavaServiceAutoConfiguration implements WebFluxConfigurer {
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
