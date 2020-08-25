package com.developcollect.commonnotify.exception;

import com.developcollect.dcinfra.exception.AbstractSimpleParameterRuntimeException;

/**
 * @author zak
 * @version 1.0.0
 */
public class NotifyException extends AbstractSimpleParameterRuntimeException {
    public NotifyException() {
        super();
    }

    public NotifyException(String message) {
        super(message);
    }

    public NotifyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotifyException(Throwable cause) {
        super(cause);
    }

    protected NotifyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotifyException(String format, Object... params) {
        super(format, params);
    }
}
