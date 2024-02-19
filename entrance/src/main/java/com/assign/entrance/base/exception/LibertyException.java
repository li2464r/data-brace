package com.assign.entrance.base.exception;

import java.io.Serializable;

/**
 * 自定义处理异常
 *
 * @author <a href="mailto:li2464r@163.com">R</a>
 * @date 2023/10/19 019 下午 02:40
 */
public class LibertyException extends RuntimeException implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = -7034897190745766939L;

    public LibertyException() {
        super();
    }

    public LibertyException(String message) {
        super(message);
    }

    public LibertyException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibertyException(Throwable cause) {
        super(cause);
    }

    protected LibertyException(String message,
                               Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
