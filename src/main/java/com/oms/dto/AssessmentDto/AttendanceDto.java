package com.oms.dto.AssessmentDto;

import com.oms.Entity.Attendance;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {


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

    public AttendanceDto(Attendance attendance) {
        this.attendanceId = attendance.getAttendanceId();
        this.date = attendance.getDate();
        this.hours = attendance.getHours();
        this.inTime = attendance.getInTime();
        this.name = attendance.getName();
        this.outTime = attendance.getOutTime();
        this.status = attendance.getStatus();
    }

}
