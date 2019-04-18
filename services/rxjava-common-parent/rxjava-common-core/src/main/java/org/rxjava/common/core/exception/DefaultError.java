package org.rxjava.common.core.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.support.DefaultMessageSourceResolvable;

/**
 * @author happy 2019-04-16 23:45
 */
@JsonIgnoreProperties("code")
class DefaultError extends DefaultMessageSourceResolvable {
    DefaultError(String code) {
        super(code);
    }
}
