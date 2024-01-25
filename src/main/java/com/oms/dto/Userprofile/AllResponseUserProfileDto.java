package com.oms.dto.Userprofile;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AllResponseUserProfileDto {
    private String message;
    private List<UserProfileDto> list;
    private String exception;


    //constructor
    public AllResponseUserProfileDto(String message) {
        this.message = message;
    }

    //default
    public AllResponseUserProfileDto() {

    }
}
