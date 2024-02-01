package com.oms.exceptions.TotalCallsException;

import org.springframework.http.HttpStatus;


public class SomethingHasWrong extends RuntimeException {
    private HttpStatus status;


    //Constructor
    public SomethingHasWrong(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
