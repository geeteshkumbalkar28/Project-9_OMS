package com.oms.dto.TotalCallsDto;

import com.oms.Entity.TotalCalls;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalCallsDto {

    private Integer id;

    private String assignedTo;
    private String calls;
    private OffsetDateTime date;
    private String endDate;
    private String message;
    private Boolean status;
    private String task;
    private String totalCall;
    private OffsetDateTime totalCallAttended;
    private String totalPeopleConsulted;
    private String totalReplies;

    //Dto to Entity
    public TotalCallsDto(TotalCalls totalCalls) {
        this.id = totalCalls.getId();
        this.assignedTo = totalCalls.getAssignedTo();
        this.calls = totalCalls.getCalls();
        this.date = totalCalls.getDate();
        this.endDate = totalCalls.getEndDate();
        this.message = totalCalls.getMessage();
        this.status = totalCalls.getStatus();
        this.task = totalCalls.getTask();
        this.totalCall = totalCalls.getTotalCall();
        this.totalCallAttended = totalCalls.getTotalCallAttended();
        this.totalPeopleConsulted = totalCalls.getTotalPeopleConsulted();
        this.totalReplies = totalCalls.getTotalReplies();

    }


}
