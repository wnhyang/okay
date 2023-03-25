package org.okay4cloud.okay.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author wnhyang
 * @date 2023/3/25
 **/
@NoArgsConstructor
public class ParamException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ParamException(String message) {
        super(message);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
