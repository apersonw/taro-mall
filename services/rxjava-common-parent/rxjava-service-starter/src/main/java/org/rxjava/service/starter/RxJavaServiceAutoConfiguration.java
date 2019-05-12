package org.rxjava.service.starter;

import org.rxjava.service.starter.boot.BaseRxJavaWebFluxConfigurer;
import org.rxjava.service.starter.boot.ServiceDelegatingWebFluxConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * @author happy 2019-04-09 01:32
 * 通用自动配置starter
 */
@Configuration
@Import({
        ServiceDelegatingWebFluxConfiguration.class
})
@EnableDiscoveryClient
@EnableMongoAuditing
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class RxJavaServiceAutoConfiguration extends BaseRxJavaWebFluxConfigurer {

}
