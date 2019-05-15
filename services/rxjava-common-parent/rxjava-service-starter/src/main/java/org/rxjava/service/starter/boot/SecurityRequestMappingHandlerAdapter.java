package org.rxjava.service.starter.boot;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rxjava.common.core.annotation.Login;
import org.rxjava.common.core.entity.LoginInfo;
import org.rxjava.common.core.exception.LoginRuntimeException;
import org.rxjava.common.core.utils.JsonUtils;
import org.springframework.http.server.PathContainer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.rxjava.service.starter.boot.LoginInfoArgumentResolver.LOGIN_REQUEST_ATTRIBUTE;

/**
 * @author happy 2019-04-16 23:05
 * 安全请求映射处理适配器
 */
public class SecurityRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {
    private static final Logger log = LogManager.getLogger();
    private static final String LOGIN_INFO = "loginInfo";

    SecurityRequestMappingHandlerAdapter() {
        super();
    }

    @Override
    public boolean supports(Object handler) {
        return super.supports(handler);
    }

    @Override
    public Mono<HandlerResult> handle(ServerWebExchange exchange, Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        ServerHttpRequest request = exchange.getRequest();
        PathContainer path = request.getPath().pathWithinApplication();
        String pathValue = path.value();
        //微服务接口不走登陆检查
        if (pathValue.startsWith("/serve")) {
            return super.handle(exchange, handler);
        }

        Login methodAnnotation = handlerMethod.getMethodAnnotation(Login.class);
        RequestMapping requestMapping = handlerMethod.getMethodAnnotation(RequestMapping.class);

        //检查是否需要登陆
        if (methodAnnotation == null || methodAnnotation.value()) {

            String loginInfoJson = request.getHeaders().getFirst(LOGIN_INFO);
            LoginInfo loginInfo = parseLoginJson(loginInfoJson);

            if (loginInfo == null) {
                throw LoginRuntimeException.of("未登录:" + request.getPath());
            }
            //请求参数注入登陆信息对象
            exchange.getAttributes().put(LOGIN_REQUEST_ATTRIBUTE, loginInfo);
            //todo:其他的一些诸如权限检查
        }
        return super.handle(exchange, handler);
    }

    /**
     * 解析网关注入的登陆信息
     */
    private LoginInfo parseLoginJson(String loginInfoJson) {
        log.info("parseLoginJson:{}", loginInfoJson);
        if (StringUtils.isEmpty(loginInfoJson)) {
            return null;
        }
        try {
            loginInfoJson = URLDecoder.decode(loginInfoJson, "utf8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return JsonUtils.deserialize(loginInfoJson, LoginInfo.class);
    }
}
