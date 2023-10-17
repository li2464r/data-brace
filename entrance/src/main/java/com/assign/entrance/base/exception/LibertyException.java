package com.assign.entrance.base.exception;

import java.io.Serializable;

public class LibertyException extends Exception implements Serializable {

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
