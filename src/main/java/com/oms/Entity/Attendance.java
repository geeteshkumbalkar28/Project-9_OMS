package com.oms.Entity;

import com.oms.dto.AssessmentDto.AttendanceDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.time.OffsetDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attendance {

    @Id
    @Column(name = "attendance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceId;

    @Column
    private OffsetDateTime date;

    @Column
    private LocalTime hours;


    @Getter
    @Column
    private LocalTime inTime;

    @Getter
    @Column
    private String name;

    @Getter
    @Column
    private LocalTime outTime;

    @Column(length = 45)
    private Integer userId;

    @Column(length = 45)
    private String status;

    public Attendance(AttendanceDto attendanceDto) {
        this.attendanceId = attendanceDto.getAttendanceId();
        this.date=attendanceDto.getDate();
        this.hours=attendanceDto.getHours();
        this.inTime=attendanceDto.getInTime();
        this.name=attendanceDto.getName();
        this.outTime=attendanceDto.getOutTime();
        this.status= attendanceDto.getStatus();
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public void setInTime(LocalTime inTime) {
        this.inTime = inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOutTime(LocalTime outTime) {
        this.outTime = outTime;
    }
}