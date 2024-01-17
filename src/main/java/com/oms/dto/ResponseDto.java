package com.oms.dto;

import com.oms.Entity.Interview;
import lombok.Data;

@Data
public class ResponseDto {

    private String status;
    private Interview response;
    private String exception;

    public ResponseDto(String status) {
        this.status = status;
    }


    public void setResponse(String deleteinterview) {
    }
}