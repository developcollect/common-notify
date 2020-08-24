package com.developcollect.commonnotify.exception;

import com.developcollect.dcinfra.exception.AbstractSimpleParameterRuntimeException;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/24 13:48
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
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
