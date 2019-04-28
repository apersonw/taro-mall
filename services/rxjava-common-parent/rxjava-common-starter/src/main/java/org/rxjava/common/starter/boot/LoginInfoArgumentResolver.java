package org.rxjava.common.starter.boot;

import org.springframework.core.MethodParameter;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolverSupport;
import org.springframework.web.reactive.result.method.SyncHandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author happy 2019-04-14 17:21
 * 登陆信息参数解析
 */
public class LoginInfoArgumentResolver extends HandlerMethodArgumentResolverSupport implements SyncHandlerMethodArgumentResolver {

    public static final String ACCOUNT_REQUEST_ATTRIBUTE = LoginInfoArgumentResolver.class.getName() + "ACCOUNT_REQUEST_ATTRIBUTE";

    protected LoginInfoArgumentResolver(ReactiveAdapterRegistry adapterRegistry) {
        super(adapterRegistry);
    }

    @Override
    public Object resolveArgumentValue(MethodParameter parameter, BindingContext bindingContext, ServerWebExchange exchange) {
        return exchange.getAttribute(LoginInfoArgumentResolver.ACCOUNT_REQUEST_ATTRIBUTE);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(LoginInfo.class);
    }
}
