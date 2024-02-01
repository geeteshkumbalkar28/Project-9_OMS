package com.oms.dto.TotalCallsDto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TotalCallResponseDto {
    private String Status;
    private String meassage;

    public TotalCallResponseDto(String status, String meassage) {
        Status = status;
        this.meassage = meassage;
    }

    //Default Constructor
    public TotalCallResponseDto() {
    }


}
