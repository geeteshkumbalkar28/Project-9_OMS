package com.oms.dto.TotalInterviewDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InterviewDeleteResponse {
    private String Status;
    //    private TotalInterviewsDto response;
    private Exception exception;

    public InterviewDeleteResponse(String status) {
        this.Status = status;
    }

    public void setException(String s) {
    }

    public void setResponse(String s) {
    }
}
