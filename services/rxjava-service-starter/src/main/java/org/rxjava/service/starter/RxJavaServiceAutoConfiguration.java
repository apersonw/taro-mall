package org.rxjava.service.starter;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.core.Ordered;

/**
 * @author happy 2019-04-09 01:32
 * 响应式服务自动配置starter
 */
@Configuration
@EnableDiscoveryClient
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class RxJavaServiceAutoConfiguration implements WebFluxConfigurer {
    public RxJavaServiceAutoConfiguration() {
    }
}
