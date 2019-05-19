package org.rxjava.service.starter.boot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rxjava.common.core.exception.ErrorMessage;
import org.rxjava.common.core.exception.ErrorMessageException;
import org.rxjava.common.core.exception.LoginRuntimeException;
import org.rxjava.common.core.utils.ErrorMessageUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author happy 2019-04-18 00:47
 * Json响应状态异常处理器
 */
public class JsonResponseStatusExceptionHandler extends ResponseStatusExceptionHandler implements ErrorWebExceptionHandler, InitializingBean, MessageSourceAware {
    private static final Logger log = LogManager.getLogger();
    private List<HttpMessageWriter<?>> messageWriters = Collections.emptyList();
    private List<ViewResolver> viewResolvers = Collections.emptyList();
    private MessageSourceAccessor messageAccessor;

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable throwable) {
        if (exchange.getResponse().isCommitted()) {
            return Mono.error(throwable);
        }

        return renderErrorResponse(exchange, throwable)
                .flatMap(response -> write(exchange, response));
    }

    private Mono<? extends Void> write(ServerWebExchange exchange,
                                       ServerResponse response) {
        exchange.getResponse().getHeaders()
                .setContentType(response.headers().getContentType());
        return response.writeTo(exchange, serverResponseContext);
    }

    protected Mono<ServerResponse> renderErrorResponse(ServerWebExchange exchange, Throwable throwable) {
        ErrorMessage errorMessage = toErrorMessage(exchange, throwable);

        return ServerResponse.status(errorMessage.getStatus())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(errorMessage));
    }

    public ErrorMessage toErrorMessage(ServerWebExchange exchange, Throwable ex) {
        HttpStatus status;
        ErrorMessage errorMessage;
        ServerHttpRequest request = exchange.getRequest();
        if (ex instanceof WebExchangeBindException) {
            WebExchangeBindException bindEx = (WebExchangeBindException) ex;
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            errorMessage = transform(bindEx.getBindingResult());

            log.info("BindException:", ex);
        } else if (ex instanceof ErrorMessageException) {
            ErrorMessageException errorMessageException = (ErrorMessageException) ex;
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            errorMessage = errorMessageException.getErrorMessage();

            log.info("ErrorMessageException:", ex);
        } else if (ex instanceof ResponseStatusException) {
            ResponseStatusException responseStatusException = (ResponseStatusException) ex;
            status = responseStatusException.getStatus();
            errorMessage = new ErrorMessage(responseStatusException.getReason());

            RequestPath path = request.getPath();
            log.info("http status:{},reason:{},path:{},method:{}", status, responseStatusException.getReason(), path, request.getMethodValue());
            log.debug("http status:{},reason:{}", status, responseStatusException.getReason(), ex);
        } else if (ex instanceof LoginRuntimeException) {
            status = HttpStatus.UNAUTHORIZED;
            errorMessage = new ErrorMessage("unauthorized");
            log.info("http status:{},reason:{}", status, "需要登录");
            log.debug("http status:{},reason:{}", status, "需要登录", ex);
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.info("Error:", ex);
            errorMessage = new ErrorMessage("server.error", (Object) ex.getMessage());
        }
        errorMessage.setStatus(status.value());
        errorMessage.setTimestamp(LocalDateTime.now());

        errorMessage.setPath(request.getPath().pathWithinApplication().value());

        ErrorMessageUtils.handlerI18n(errorMessage, messageAccessor);

        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);
        return errorMessage;
    }

    public static ErrorMessage transform(BindingResult bindingResult) {
        ErrorMessage errorMessage = new ErrorMessage("server.validator");

        for (ObjectError error : bindingResult.getAllErrors()) {
            String key = (error instanceof FieldError
                    ? ((FieldError) error).getField()
                    : error.getObjectName());
            errorMessage.addFieldObjs(key, error.getCodes(), error.getArguments());
        }
        return errorMessage;
    }

    public void setMessageWriters(List<HttpMessageWriter<?>> messageWriters) {
        Assert.notNull(messageWriters, "'messageWriters' must not be null");
        this.messageWriters = messageWriters;
    }

    public void setViewResolvers(List<ViewResolver> viewResolvers) {
        this.viewResolvers = viewResolvers;
    }

    private ServerResponse.Context serverResponseContext = new ServerResponse.Context() {
        @Override
        public List<HttpMessageWriter<?>> messageWriters() {
            return messageWriters;
        }

        @Override
        public List<ViewResolver> viewResolvers() {
            return viewResolvers;
        }
    };

    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollectionUtils.isEmpty(this.messageWriters)) {
            throw new IllegalArgumentException("Property 'messageWriters' is required");
        }
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageAccessor = new MessageSourceAccessor(messageSource, Locale.CHINA);
    }
}
