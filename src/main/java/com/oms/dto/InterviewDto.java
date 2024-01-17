package com.oms.dto;

import com.oms.controller.InterviewController;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.OffsetDateTime;

@Getter
@Setter
public class InterviewDto {

    public String firstName;
    public String lastName;
    public String email;
    public String mobileNo;
    public OffsetDateTime interviewDate;
    public LocalTime interviewTime;
    public String profile;
    public String gender;
    public String status;
    public OffsetDateTime date;
    public String location;
    public String mode;
    public String result;
    private InterviewController response;

    public void setResponse(InterviewController response) {
        this.response = response;
    }

    public InterviewController getResponse() {
        return response;
    }
}
