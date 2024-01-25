package com.oms.dto.Userprofile;

import lombok.Data;


@Data
public class UserProfileDeleteResponse {

    private String Status;
    // private UserProfileDto response;
    private Exception exception;

    public UserProfileDeleteResponse(String status) {
        this.Status = status;
    }

    public void setException(String s) {
    }

    public void setResponse(String s) {
    }


}
