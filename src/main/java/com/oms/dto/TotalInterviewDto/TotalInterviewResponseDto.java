package com.oms.dto.TotalInterviewDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalInterviewResponseDto {


    private String Status;
    private String meassage;

    public TotalInterviewResponseDto(String status, String meassage) {
        Status = status;
        this.meassage = meassage;
    }

    public TotalInterviewResponseDto() {
    }
}
