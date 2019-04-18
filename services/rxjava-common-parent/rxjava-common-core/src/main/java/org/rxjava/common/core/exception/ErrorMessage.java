package org.rxjava.common.core.exception;

import lombok.Data;
import org.springframework.context.MessageSourceResolvable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author happy 2019-04-18 01:14
 */
@Data
public class ErrorMessage implements MessageSourceResolvable {
    private String[] codes;
    private Object[] arguments;
    private String defaultMessage;
    private LocalDateTime timestamp;
    private String path;
    private String message;
    private List<FieldError> errors;
    /**
     * 状态字段
     */
    private int status;

    public ErrorMessage(String[] codes, Object[] arguments, String defaultMessage) {
        this.codes = codes;
        this.arguments = arguments;
        this.defaultMessage = defaultMessage;
    }

    public ErrorMessage(String code, Object... args) {
        this(new String[]{code}, args);
    }

    public ErrorMessage(String[] codes, Object[] arguments) {
        this(codes, arguments, codes[0]);
    }

    public ErrorMessage(String code, String... argCode) {
        this(code, (Object[]) Stream.of(argCode)
                .map(DefaultError::new)
                .toArray(DefaultError[]::new));
    }

    public ErrorMessage addFieldObjs(String field, String[] codes, Object... args) {
        return add(new FieldError(field, codes, args));
    }

    public ErrorMessage add(FieldError fieldError) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(fieldError);
        return this;
    }
}
