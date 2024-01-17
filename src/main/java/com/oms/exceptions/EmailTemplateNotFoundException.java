package com.oms.exceptions;

public class EmailTemplateNotFoundException extends RuntimeException{
    public EmailTemplateNotFoundException(String message) {
        super(message);
    }
}
