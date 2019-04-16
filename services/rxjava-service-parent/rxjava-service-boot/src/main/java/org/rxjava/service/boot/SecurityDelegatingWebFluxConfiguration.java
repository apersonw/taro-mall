package org.rxjava.service.boot;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerAdapter;

/**
 * @author happy 2019-04-16 23:04
 * 权限处理适配器配置
 */
@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 12)
public class SecurityDelegatingWebFluxConfiguration extends DelegatingWebFluxConfiguration {

    @Override
    @Bean
    @ConditionalOnMissingBean
    protected RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
        return new SecurityHandlerAdapter();
    }
}
