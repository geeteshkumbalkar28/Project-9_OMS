package com.oms.exceptions.TotalInterviewException;

import org.springframework.http.HttpStatus;

public class Somethingwentwrong extends RuntimeException {

    private HttpStatus status;

    //Constructor
    public Somethingwentwrong(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }


}
