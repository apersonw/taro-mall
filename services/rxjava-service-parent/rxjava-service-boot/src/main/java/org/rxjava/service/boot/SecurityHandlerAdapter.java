package org.rxjava.service.boot;

import org.apache.commons.lang3.StringUtils;
import org.rxjava.service.boot.annotation.Login;
import org.rxjava.service.boot.exception.ErrorMessageException;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-04-16 23:05
 */
public class SecurityHandlerAdapter extends RequestMappingHandlerAdapter {
    private static final String TOKEN_HEADER_NAME = "Authorization";

    SecurityHandlerAdapter() {
        super();
    }

    @Override
    public boolean supports(Object handler) {
        return super.supports(handler);
    }

    @Override
    public Mono<HandlerResult> handle(ServerWebExchange exchange, Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Login methodAnnotation = handlerMethod.getMethodAnnotation(Login.class);

        ServerHttpRequest request = exchange.getRequest();
        String authorization = request.getHeaders().getFirst(TOKEN_HEADER_NAME);

        //检查是否需要登陆
        if (methodAnnotation == null || methodAnnotation.value()) {
            if (StringUtils.isEmpty(authorization)) {
                throw ErrorMessageException.of("未登录:" + request.getPath());
            }
            //todo:其他的一些诸如权限检查
        }
        return super.handle(exchange, handler);
    }
}
