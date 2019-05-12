package org.rxjava.service.starter.boot;

import org.rxjava.common.core.entity.LoginInfo;
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

    static final String LOGIN_REQUEST_ATTRIBUTE = LoginInfoArgumentResolver.class.getName() + "LOGIN_REQUEST_ATTRIBUTE";

    public LoginInfoArgumentResolver(ReactiveAdapterRegistry adapterRegistry) {
        super(adapterRegistry);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(LoginInfo.class);
    }

    @Override
    public Object resolveArgumentValue(MethodParameter parameter, BindingContext bindingContext, ServerWebExchange exchange) {
        return exchange.getAttribute(LoginInfoArgumentResolver.LOGIN_REQUEST_ATTRIBUTE);
    }
}
