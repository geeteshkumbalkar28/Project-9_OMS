package com.oms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Attendance {

    @Id
    @Column(name = "attendance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceId;

    @Column
    private OffsetDateTime date;

    @Column
    private LocalTime hours;

    @Column
    private LocalTime inTime;

    @Column
    private String name;

    @Column
    private LocalTime outTime;

    @Column(length = 45)
    private String userId;

    @Column(length = 45)
    private String status;

}