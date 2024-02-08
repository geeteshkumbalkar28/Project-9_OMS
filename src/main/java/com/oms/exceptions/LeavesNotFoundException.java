package com.oms.exceptions;

public class LeavesNotFoundException extends RuntimeException{
    private String httpStatus;

    public LeavesNotFoundException(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LeavesNotFoundException(String message, String httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
