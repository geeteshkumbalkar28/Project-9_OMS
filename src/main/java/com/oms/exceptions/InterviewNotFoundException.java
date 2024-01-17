package com.oms.exceptions;

public class InterviewNotFoundException extends RuntimeException{
    private String httpStatus;

    public InterviewNotFoundException(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public InterviewNotFoundException(String message, String httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
