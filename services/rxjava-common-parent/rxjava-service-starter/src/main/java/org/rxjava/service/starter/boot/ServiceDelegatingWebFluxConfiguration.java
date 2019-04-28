package org.rxjava.service.starter.boot;

import org.rxjava.common.starter.boot.RxjavaDelegatingWebFluxConfiguration;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.util.Collections;
import java.util.List;

/**
 * @author happy 2019-04-16 23:04
 * 覆盖SpringWebFlux默认配置Bean
 */
public class ServiceDelegatingWebFluxConfiguration extends RxjavaDelegatingWebFluxConfiguration {

    @Override
    @Bean
    @ConditionalOnMissingBean
    protected RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
        return new SecurityRequestMappingHandlerAdapter();
    }
}
