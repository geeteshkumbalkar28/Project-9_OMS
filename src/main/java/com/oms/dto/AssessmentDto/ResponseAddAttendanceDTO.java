package com.oms.dto.AssessmentDto;

import lombok.Data;

@Data
public class ResponseAddAttendanceDTO {

    private String message;
    private Object object;
    private String exception;

    public ResponseAddAttendanceDTO(String message)
    {
        this.message = message;
    }
}
