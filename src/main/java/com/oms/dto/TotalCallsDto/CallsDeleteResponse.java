package com.oms.dto.TotalCallsDto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CallsDeleteResponse {

    private String Status;
    //    private TotalCallsDto response;
    private String exception;

    public CallsDeleteResponse(String status) {
        this.Status = status;
    }

    public void setException(String s) {
    }

    public void setResponse(String s) {
    }
}
