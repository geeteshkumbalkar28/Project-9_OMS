package com.oms.dto.AssessmentDto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllClientDTO {

    private String message;
    private List<ClientDto> list;
    private String exception;

    public ResponseAllClientDTO(String message)
    {
        this.message = message;
    }
}
