package com.oms.dto;


import com.oms.controller.LeavesController;
import lombok.Data;

@Data
public class ResponseLeaveDto {
    private String status;
    private LeavesController response;
    private String exception;

    public ResponseLeaveDto(String status, String message) {
        this.status = status;
    }

    public void setResponse() {
    }
}

