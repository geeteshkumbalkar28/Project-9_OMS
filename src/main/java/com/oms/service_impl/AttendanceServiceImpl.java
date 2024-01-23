package com.oms.service_impl;

import com.oms.Entity.Attendance;
import com.oms.Entity.Users;
import com.oms.dto.AssessmentDto.AttendanceDto;
import com.oms.exceptions.AssesmentException.AssessmentNotFoundException;
import com.oms.repositories.AttendanceRepository;
import com.oms.repositories.UsersRepository;
import com.oms.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    UsersRepository usersRepository;


    @Override
    public String AddAttendance(AttendanceDto attendanceDto, Integer userId) {
        Optional<Users> byId = usersRepository.findById(userId);
        if (byId.isPresent()) {
            Attendance attendance = new Attendance(attendanceDto);
            attendance.setUserId(byId.get().getUserId());
            attendanceRepository.save(attendance);
            return "Attendance Marked Successfully";
        }
        return "User Not Found";
    }

    @Override
    public AttendanceDto GetById(Integer attendanceId) {
        Optional<Attendance> byId = attendanceRepository.findById(attendanceId);
        if (byId.isEmpty()){
            throw new AssessmentNotFoundException("Attendance NOt Found", HttpStatus.NOT_FOUND);
        }
        AttendanceDto attendanceDto = new AttendanceDto(byId.get());
        attendanceDto.setAttendanceId(attendanceId);
        return attendanceDto;
    }

    @Override
    public List<AttendanceDto> getAllAttendance() {
        List<Attendance> all = attendanceRepository.findAll();
        return all.stream().map(AttendanceDto::new).collect(Collectors.toList());
    }

    @Override
    public String deleteAttendance(Integer attendanceId) {
        AttendanceDto attendanceDto = GetById(attendanceId);
        if (attendanceDto == null){
            throw new AssessmentNotFoundException("Id Not Found");
        }
        attendanceRepository.deleteById(attendanceId);
        return "Attendance Deleted Successfully";
    }



    @Override
    public String updateAttendance(Integer attendanceId, AttendanceDto attendanceDto) {

        Attendance attendance = attendanceRepository.findById(attendanceId).orElseThrow(() -> new AssessmentNotFoundException("Attendance Not Found", HttpStatus.NOT_FOUND));

        if (attendanceDto.getName() != null) {
            attendance.setName(attendanceDto.getName());
        }

        if (attendanceDto.getDate() != null) {
            attendance.setDate(attendanceDto.getDate());
        }

        if (attendanceDto.getHours() != null) {
            attendance.setHours(attendanceDto.getHours());
        }

        if (attendanceDto.getInTime() != null) {
            attendance.setInTime(attendanceDto.getInTime());
        }

        if (attendanceDto.getOutTime() != null) {
            attendance.setOutTime(attendanceDto.getOutTime());
        }

        if (attendanceDto.getStatus() != null) {
            attendance.setStatus(attendanceDto.getStatus());
        }

       attendanceRepository.save(attendance);

        return "Attendance Updated";
    }


}
