package com.oms.exceptions.UserProfileException;

public class Inaccurate25 extends RuntimeException {
    private String httpStatus;

    public Inaccurate25(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Inaccurate25(String message, String httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
