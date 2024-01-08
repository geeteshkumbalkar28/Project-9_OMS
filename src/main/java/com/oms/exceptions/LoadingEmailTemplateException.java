package com.oms.exceptions;

public class LoadingEmailTemplateException extends RuntimeException{
    public LoadingEmailTemplateException(String message) {
        super(message);
    }
}
