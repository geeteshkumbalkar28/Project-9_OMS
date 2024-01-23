package com.oms.exceptions.AssesmentException;

import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;

    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
