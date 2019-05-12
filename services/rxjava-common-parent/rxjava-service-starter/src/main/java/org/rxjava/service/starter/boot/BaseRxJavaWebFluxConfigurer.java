package org.rxjava.service.starter.boot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.rxjava.common.core.utils.JsonUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author happy 2019-05-13 01:30
 */
public abstract class BaseRxJavaWebFluxConfigurer implements WebFluxConfigurer {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss.SSS";

    @Bean
    @Primary
    ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
    }

    /**
     * 配置时间格式解析
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = JsonUtils.create();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module());

        DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).withZone(ZoneId.systemDefault());
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dataFormatter));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(dataFormatter));

        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(timeFormatter));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(timeFormatter));

        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dataTimeFormatter));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dataTimeFormatter));

        javaTimeModule.addDeserializer(Instant.class, new JsonDeserializer<Instant>() {
            @Override
            public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                return Instant.from(dataTimeFormatter.parse(jsonParser.getText()));
            }
        });

        javaTimeModule.addSerializer(Instant.class, new JsonSerializer<Instant>() {
            @Override
            public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                String str = dataTimeFormatter.format(value);
                gen.writeString(str);
            }
        });

        objectMapper.registerModule(javaTimeModule);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        simpleDateFormat.setLenient(false);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper;
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

    @Bean
    public ReactiveAdapterRegistry customWebFluxAdapterRegistry() {
        return new ReactiveAdapterRegistry();
    }

    /**
     * 注入登陆信息参数解析器
     */
    @Bean
    public LoginInfoArgumentResolver loginInfoArgumentResolver() {
        return new LoginInfoArgumentResolver(customWebFluxAdapterRegistry());
    }

    @Override
    public void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
        configurer.addCustomResolver(loginInfoArgumentResolver());
    }
}
