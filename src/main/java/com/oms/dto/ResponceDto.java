package com.oms.dto;

import com.oms.Entity.Interview;
import lombok.Data;

@Data
public class ResponceDto {

    private String status;
    private Interview response;
    private String exception;

    public ResponceDto(String status, String message) {
        this.status = status;
    }


}
