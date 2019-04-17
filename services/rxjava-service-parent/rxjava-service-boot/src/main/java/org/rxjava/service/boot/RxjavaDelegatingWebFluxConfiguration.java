package org.rxjava.service.boot;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.List;

/**
 * @author happy 2019-04-16 23:04
 * 重构SpringWebFlux默认配置
 */
public class RxjavaDelegatingWebFluxConfiguration extends DelegatingWebFluxConfiguration {

    @Override
    @Bean
    @ConditionalOnMissingBean
    protected RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
        return new SecurityHandlerAdapter();
    }

    /**
     * 注入json响应状态异常处理器
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ErrorWebExceptionHandler responseStatusExceptionHandler(
            ObjectProvider<List<ViewResolver>> viewResolversProvider,
            ServerCodecConfigurer serverCodecConfigurer
    ) {
        JsonResponseStatusExceptionHandler handler = new JsonResponseStatusExceptionHandler();
        handler.setMessageWriters(serverCodecConfigurer.getWriters());
        handler.setViewResolvers(viewResolversProvider.getIfAvailable(Collections::emptyList));
        return handler;
    }
}
