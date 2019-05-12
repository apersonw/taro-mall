package org.rxjava.test.user;

import org.rxjava.test.user.http.client.UserApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author happy 2019-05-10 17:39
 */
@Configuration
public class TestContext {
    @Bean
    public ConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        DefaultConversionService.addCollectionConverters(conversionService);
        DefaultConversionService.addDefaultConverters(conversionService);
        addFormatters(conversionService);
        return conversionService;
    }

    public void addFormatters(FormatterRegistry registry) {
    }

    @Bean
    public UserApi userApi(ConversionService conversionService) {
        WebClient.Builder builder = WebClient.builder();
        ReactiveHttpClientAdapter clientAdapter = ReactiveHttpClientAdapter.build(conversionService, builder, "127.0.0.1:8081");
        return new UserApi(clientAdapter);
    }
}
