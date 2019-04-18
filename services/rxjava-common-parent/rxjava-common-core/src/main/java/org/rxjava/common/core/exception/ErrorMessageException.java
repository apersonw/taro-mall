package org.rxjava.common.core.exception;

import org.apache.commons.lang3.ArrayUtils;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;
import java.util.stream.Stream;

/**
 * @author happy 2019-04-16 23:37
 * 错误消息异常(可预知错误均抛出此异常)
 */
public class ErrorMessageException extends RuntimeException {
    private ErrorMessage errorMessage;
    private ErrorMessageException(String[] codes, Object[] arguments, String defaultMessage, Throwable cause) {
        super(MessageFormat.format(
                "codes:{0},args:{1}, defaultMessage:{2}",
                ArrayUtils.toString(codes),
                ArrayUtils.toString(arguments),
                defaultMessage
        ), cause);
        this.errorMessage = new ErrorMessage(codes, arguments, defaultMessage);
    }

    /**
     * 解析错误码和参数码
     *
     * @param code     错误码
     * @param argsCode 参数码
     * @return 解析后的异常
     */
    private static ErrorMessageException parseCode(String code, String... argsCode) {
        return new ErrorMessageException(code, argsCode);
    }

    private ErrorMessageException(String code, String... argsCodes) {
        this(new String[]{code}, Stream.of(argsCodes).map(DefaultError::new).toArray(DefaultError[]::new), null, null);
    }

    public static <T> Mono<T> mono(String code) {
        return Mono.error(parseCode(code));
    }

    public static ErrorMessageException of(String code) {
        return new ErrorMessageException(new String[]{code}, null, null, null);
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
