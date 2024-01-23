package com.oms.dto.AssessmentDto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllAttendanceDTO {

    private String message;
    private List<AttendanceDto> list;
    private String exception;

    public ResponseAllAttendanceDTO(String message)
    {
        this.message = message;
    }
}
