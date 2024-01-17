package com.oms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSingleInterviewDto {

    private String message;
    private Object object;
    private String exception;

    public ResponseSingleInterviewDto(String message)
    {
        this.message = message;
    }

}