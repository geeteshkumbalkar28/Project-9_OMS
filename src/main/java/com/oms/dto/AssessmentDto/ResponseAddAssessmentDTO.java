package com.oms.dto.AssessmentDto;

import lombok.Data;

@Data
public class ResponseAddAssessmentDTO {
    private String message;
    private Object object;
    private String exception;

    public ResponseAddAssessmentDTO(String message)
    {
        this.message = message;
    }
}
