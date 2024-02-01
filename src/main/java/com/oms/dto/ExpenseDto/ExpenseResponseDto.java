package com.oms.dto.ExpenseDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseResponseDto {

    private String Status;
    private String meassage;

    public ExpenseResponseDto(String status, String meassage) {
        Status = status;
        this.meassage = meassage;
    }

    //Default Constructor
    public ExpenseResponseDto() {
    }

}
