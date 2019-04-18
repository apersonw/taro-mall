package org.rxjava.common.core.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.util.Assert;
import reactor.util.annotation.Nullable;

import java.util.Arrays;

/**
 * @author happy 2019-04-18 01:32
 */
@JsonIgnoreProperties("code")
public class FieldError implements MessageSourceResolvable {
    private String[] codes;
    private Object[] arguments;
    private String defaultMessage;


    private String field;
    private String message;

    public FieldError() {
    }

    private FieldError(String[] codes, Object[] arguments, String defaultMessage) {
        this.codes = codes;
        this.arguments = arguments;
        this.defaultMessage = defaultMessage;
    }

    /**
     * Create a new instance of the ObjectError class.
     *
     * @param field          the name of the affected object
     * @param defaultMessage the default message to be used to resolve this message
     */
    public FieldError(String field, String defaultMessage) {
        this(field, null, null, defaultMessage);
    }

    /**
     * Create a new instance of the ObjectError class.
     *
     * @param field          the name of the affected object
     * @param codes          the codes to be used to resolve this message
     * @param arguments      the array of arguments to be used to resolve this message
     * @param defaultMessage the default message to be used to resolve this message
     */
    public FieldError(
            String field,
            @Nullable String[] codes,
            @Nullable Object[] arguments,
            @Nullable String defaultMessage) {
        this(codes, arguments, defaultMessage);
        Assert.notNull(field, "Object name must not be null");
        this.field = field;
    }

    public FieldError(
            String field,
            @Nullable String[] codes,
            @Nullable Object[] arguments
    ) {
        this(codes, arguments, null);
        Assert.notNull(field, "Object name must not be null");
        this.field = field;
    }

    public String getField() {
        return field;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String[] getCodes() {
        return this.codes;
    }


    public String getCode() {
        return this.codes != null && this.codes.length > 0 ? this.codes[this.codes.length - 1] : null;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }


    @Override
    public String getDefaultMessage() {
        String defaultMessage = this.defaultMessage;
        if (defaultMessage == null) {
            return getCode();
        }
        return defaultMessage;
    }

    public void setCodes(String[] codes) {
        this.codes = codes;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String toString() {
        return "FieldError{" +
                "codes=" + Arrays.toString(codes) +
                ", arguments=" + Arrays.toString(arguments) +
                ", defaultMessage='" + defaultMessage + '\'' +
                ", field='" + field + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
