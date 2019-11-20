package org.rxjava.service.goods;

import org.rxjava.common.bus.EnableBus;
import org.rxjava.service.goods.config.GoodsProperties;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
@EnableConfigurationProperties(GoodsProperties.class)
@EnableBus
public class RxServiceGoodsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxServiceGoodsApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }
}
