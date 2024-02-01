package com.oms.dto.TotalCallsDto;


import lombok.Data;

import java.util.List;

@Data
public class TotalResponseAllCallsDTO {

    private String message;
    private List<TotalCallsDto> list;
    private String exception;


    //constructor
    public TotalResponseAllCallsDTO(String message) {
        this.message = message;
    }
}
