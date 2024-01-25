package com.oms.dto.TotalInterviewDto;


import lombok.Data;

import java.util.List;

@Data
public class TotalResponseAllInterviewDto {
    private String message;
    private List<TotalInterviewsDto> list;
    private String exception;


    //constructor
    public TotalResponseAllInterviewDto(String message) {
        this.message = message;
    }
}
