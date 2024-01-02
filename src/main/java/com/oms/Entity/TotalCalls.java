package com.oms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
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

    @Column(nullable = false)
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

}