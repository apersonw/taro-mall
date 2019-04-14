package org.rxjava.service.goods;

import org.rxjava.service.goods.converter.DateToStringConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author happy 2019-04-07 15:31
 */
@Configuration
public class RxjavaWebFluxConfigurer implements WebFluxConfigurer {
    private static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //使用yyyy-MM-dd HH:mm:ss 样式的日期转换器
        registry.addConverter(new DateToStringConverter(FORMAT_PATTERN));
    }
}
