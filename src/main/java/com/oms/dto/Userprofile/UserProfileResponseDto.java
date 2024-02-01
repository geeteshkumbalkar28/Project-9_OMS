package com.oms.dto.Userprofile;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class UserProfileResponseDto {

    private String status;
    private String meassage;

    public UserProfileResponseDto(String status, String meassage) {
        this.status = status;
        this.meassage = meassage;
    }

    //Default Constructor
    public UserProfileResponseDto() {
    }


}
