package com.developcollect.commonnotify.exception;

import com.developcollect.dcinfra.exception.AbstractSimpleParameterRuntimeException;

/**
 * @author zak
 * @version 1.0.0
 */
public class SendException extends AbstractSimpleParameterRuntimeException {
    public SendException() {
        super();
    }

    public SendException(String message) {
        super(message);
    }

    public SendException(String message, Throwable cause) {
        super(message, cause);
    }

    public SendException(Throwable cause) {
        super(cause);
    }

    protected SendException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SendException(String format, Object... params) {
        super(format, params);
    }
}
