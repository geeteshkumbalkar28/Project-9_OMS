package com.oms.exceptions.UserProfileException;

import org.springframework.http.HttpStatus;

public class Inaccurate extends RuntimeException {

    private HttpStatus status;

    //Constructor
    public Inaccurate(String message, HttpStatus notFound) {
        super(message);
        this.status = status;
    }
}
