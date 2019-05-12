package org.rxjava.service.starter.boot;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 12)
public class ServiceDelegatingWebFluxConfiguration extends DelegatingWebFluxConfiguration {

    @Override
    @Bean
    @ConditionalOnMissingBean
    protected RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
        return new SecurityRequestMappingHandlerAdapter();
    }

    /**
     * 注入json响应状态异常处理器
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ResponseStatusExceptionHandler responseStatusExceptionHandler(
            ObjectProvider<List<ViewResolver>> viewResolversProvider,
            ServerCodecConfigurer serverCodecConfigurer
    ) {
        JsonResponseStatusExceptionHandler handler = new JsonResponseStatusExceptionHandler();
        handler.setMessageWriters(serverCodecConfigurer.getWriters());
        handler.setViewResolvers(viewResolversProvider.getIfAvailable(Collections::emptyList));
        return handler;
    }

}
