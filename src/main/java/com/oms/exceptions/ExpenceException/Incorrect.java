package com.oms.exceptions.ExpenceException;

import org.springframework.http.HttpStatus;

public class Incorrect extends RuntimeException {

    private HttpStatus status;

    //Constructor
    public Incorrect(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
