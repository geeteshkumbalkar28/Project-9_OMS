package com.oms.dto.ExpenseDto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class ExpenseDeleteResponse {

    private String Status;
    //    private TotalInterviewsDto response;
    private Exception exception;

    public ExpenseDeleteResponse(String status) {
        this.Status = status;
    }

    public void setException(String s) {
    }

    public void setResponse(String s) {
    }
}

