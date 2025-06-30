package com.racacia.repository.base.exception;

import java.io.Serial;

public class RepositoryException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private String[] args;

    public RepositoryException() {
        super();
    }

    public RepositoryException(String message, String... args) {
        super(message);
        this.args = args;
    }

    public RepositoryException(String message, Integer arg) {
        super(message);
        this.args = new String[]{arg + ""};
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    protected RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
