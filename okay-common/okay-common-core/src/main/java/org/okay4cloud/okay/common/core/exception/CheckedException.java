package org.okay4cloud.okay.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author wnhyang
 * @date 2023/2/23
 **/
@NoArgsConstructor
public class CheckedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(Throwable cause) {
        super(cause);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
