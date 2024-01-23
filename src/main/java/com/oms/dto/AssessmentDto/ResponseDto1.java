package com.oms.dto.AssessmentDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto1 {

    public String status;
    public String message;

    public ResponseDto1(String status, String message) {
        this.status=status;
        this.message=message;
    }

    public ResponseDto1() {

    }
}
