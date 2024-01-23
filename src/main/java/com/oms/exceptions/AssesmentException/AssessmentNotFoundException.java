package com.oms.exceptions.AssesmentException;

import org.springframework.http.HttpStatus;

public class AssessmentNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;

    public AssessmentNotFoundException(String message) {
        super(message);
    }

    public AssessmentNotFoundException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
