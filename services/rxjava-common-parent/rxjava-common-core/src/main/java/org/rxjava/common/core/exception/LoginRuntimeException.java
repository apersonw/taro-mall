package org.rxjava.common.core.exception;

/**
 * @author happy 2019-04-18 01:22
 */
public class LoginRuntimeException extends RuntimeException {
    public LoginRuntimeException(String message) {
        super(message);
    }

    public static LoginRuntimeException of(String message) {
        return new LoginRuntimeException(message);
    }
}
