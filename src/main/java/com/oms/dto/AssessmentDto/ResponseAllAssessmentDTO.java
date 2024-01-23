package com.oms.dto.AssessmentDto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllAssessmentDTO {
    private String message;
    private List<AddAssesmentDto> list;
    private String exception;

    public ResponseAllAssessmentDTO(String message, String exception)
    {
        this.message = message;
        this.exception =exception;
    }
}
