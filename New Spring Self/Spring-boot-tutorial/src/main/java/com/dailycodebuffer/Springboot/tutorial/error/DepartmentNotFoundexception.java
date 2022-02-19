package com.dailycodebuffer.Springboot.tutorial.error;

public class DepartmentNotFoundexception extends Exception {

    public DepartmentNotFoundexception() {
        super();
    }

    public DepartmentNotFoundexception(String message) {
        super(message);
    }

    public DepartmentNotFoundexception(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundexception(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundexception(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
