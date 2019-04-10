package org.rxjava.service.starter;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author happy 2019-04-09 01:32
 * 响应式服务自动配置starter
 */
@Configuration
@EnableEurekaClient
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class RxJavaServiceAutoConfiguration implements WebFluxConfigurer {
    public RxJavaServiceAutoConfiguration() {
    }
}
