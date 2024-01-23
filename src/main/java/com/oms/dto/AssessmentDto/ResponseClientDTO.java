package com.oms.dto.AssessmentDto;

import lombok.Data;

@Data
public class ResponseClientDTO {

    private String message;
    private Object object;
    private String exception;

    public ResponseClientDTO(String message)
    {
        this.message = message;
    }
}
