package org.rxjava.service.starter;

import org.rxjava.service.boot.RxjavaDelegatingWebFluxConfiguration;
import org.rxjava.service.boot.RxjavaWebFluxConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

/**
 * @author happy 2019-04-09 01:32
 * 响应式服务自动配置starter
 */
@Configuration
@Import({
        RxjavaDelegatingWebFluxConfiguration.class
})
@EnableDiscoveryClient
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class RxJavaServiceAutoConfiguration extends RxjavaWebFluxConfigurer {

}
