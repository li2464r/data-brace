package com.racacia.entrance.base.exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * 自定义处理异常
 *
 * @author <a href="mailto:li2464r@163.com">R</a>
 * @date 2023/10/19 019 下午 02:40
 */
public class ParametersException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = -7034897190745766939L;

    public ParametersException() {
        super();
    }

    public ParametersException(String message) {
        super(message);
    }

    public ParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParametersException(Throwable cause) {
        super(cause);
    }

    protected ParametersException(String message,
                                  Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
