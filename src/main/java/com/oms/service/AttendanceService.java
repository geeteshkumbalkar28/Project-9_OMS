package com.oms.service;



import com.oms.dto.AssessmentDto.AttendanceDto;

import java.util.List;

public interface AttendanceService {
    String AddAttendance(AttendanceDto attendanceDto, Integer userId);

    public AttendanceDto GetById(Integer attendanceId);


   public List<AttendanceDto> getAllAttendance();


    String deleteAttendance(Integer attendanceId);


    String updateAttendance(Integer attendanceId, AttendanceDto attendanceDto);



}
