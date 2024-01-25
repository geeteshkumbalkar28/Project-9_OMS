package com.oms.Entity;

import com.oms.dto.TotalCallsDto.TotalCallsDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class TotalCalls {

    @Id
    @Column(name = "totalCall_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String assignedTo;

    @Column
    private String calls;

    @Column
    private OffsetDateTime date;

    @Column
    private String endDate;

    @Column
    private String message;

    @Column
    private Boolean status;

    @Column
    private String task;

    @Column
    private String totalCall;

    @Column
    private OffsetDateTime totalCallAttended;

    @Column
    private String totalPeopleConsulted;

    @Column
    private String totalReplies;

    public TotalCalls(TotalCallsDto totalCallsDto) {

        this.id = totalCallsDto.getId();
        this.assignedTo = totalCallsDto.getAssignedTo();
        this.calls = totalCallsDto.getCalls();
        this.date = totalCallsDto.getDate();
        this.endDate = totalCallsDto.getEndDate();
        this.message = totalCallsDto.getMessage();
        this.status = totalCallsDto.getStatus();
        this.task = totalCallsDto.getTask();
        this.totalCall = totalCallsDto.getTotalCall();
        this.totalCallAttended = totalCallsDto.getTotalCallAttended();
        this.totalPeopleConsulted = totalCallsDto.getTotalPeopleConsulted();
        this.totalReplies = totalCallsDto.getTotalReplies();


    }
}