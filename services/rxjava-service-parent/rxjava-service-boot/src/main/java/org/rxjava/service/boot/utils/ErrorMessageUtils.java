package org.rxjava.service.boot.utils;

import org.rxjava.service.boot.exception.ErrorMessage;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.CollectionUtils;

/**
 * @author happy 2019-04-18 01:25
 */
public class ErrorMessageUtils {
    public static ErrorMessage handlerI18n(ErrorMessage errorMessage, MessageSourceAccessor messageSourceAccessor) {
        if (errorMessage.getMessage() == null) {
            errorMessage.setMessage(messageSourceAccessor.getMessage(errorMessage));
        }

        if (!CollectionUtils.isEmpty(errorMessage.getErrors())) {
            errorMessage.getErrors().forEach(fieldError -> {
                if (fieldError.getMessage() == null) {
                    fieldError.setMessage(messageSourceAccessor.getMessage(fieldError));
                }
            });
        }
        return errorMessage;
    }
}
