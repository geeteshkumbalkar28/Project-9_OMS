package com.oms.dto.ExpenseDto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllResponseExpenseDto {

    private String message;
    private List<ExpenseDto> list;
    private String exception;


    //constructor
    public AllResponseExpenseDto(String message) {
        this.message = message;
    }

    //default
    public AllResponseExpenseDto() {

    }
}


