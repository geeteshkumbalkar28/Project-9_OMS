package com.oms.exceptions;

public class PageNotFoundException extends Throwable {
    public PageNotFoundException(String message) {
        super(message);
    }
}
