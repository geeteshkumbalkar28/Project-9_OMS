package com.oms.controller;

import com.oms.dto.AssessmentDto.AttendanceDto;
import com.oms.dto.AssessmentDto.ResponseAddAttendanceDTO;
import com.oms.dto.AssessmentDto.ResponseAllAttendanceDTO;
import com.oms.dto.AssessmentDto.ResponseDto1;
import com.oms.exceptions.AssesmentException.AssessmentNotFoundException;
import com.oms.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;


    @PostMapping("/add")
    public ResponseEntity<ResponseDto1> createAttendance(@RequestBody AttendanceDto attendanceDto, @RequestParam Integer userId) {
        try {
            String result = attendanceService.AddAttendance(attendanceDto, userId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", result));
        } catch (AssessmentNotFoundException assessmentNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsuccess", "User Not Found"));
        }
    }

    @GetMapping("/byID")
    public ResponseEntity<ResponseAddAttendanceDTO> GetAttendanceById(@RequestParam Integer attendanceId){
        try {
            ResponseAddAttendanceDTO success = new ResponseAddAttendanceDTO("success");
            AttendanceDto attendanceDto = attendanceService.GetById(attendanceId);
            success.setObject(attendanceDto);
            return ResponseEntity.status(HttpStatus.OK).body(success);

        }catch (AssessmentNotFoundException assessmentNotFoundException)
        {
            ResponseAddAttendanceDTO responseAddAttendanceDTO = new ResponseAddAttendanceDTO("unsuccessful");
            responseAddAttendanceDTO.setException("User Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAddAttendanceDTO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllAttendanceDTO> getAllAssessment() {
        try {
            ResponseAllAttendanceDTO success = new ResponseAllAttendanceDTO("success");
            List<AttendanceDto> allAttendance = attendanceService.getAllAttendance();
            success.setList(allAttendance);
            return ResponseEntity.status(HttpStatus.OK).body(success);
        }catch (AssessmentNotFoundException assessmentNotFoundException)
        {
            ResponseAllAttendanceDTO unsuccessful = new ResponseAllAttendanceDTO("unsuccessful");
            unsuccessful.setException("Assessment Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(unsuccessful);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto1> deleteAssessment(@RequestParam Integer attendanceId) {
        try {
            String string = attendanceService.deleteAttendance(attendanceId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", string));
        } catch (AssessmentNotFoundException assessmentNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsucces", "Id Not Found"));
        }
    }

    @PatchMapping("/update/{attendanceId}")
    public ResponseEntity<ResponseDto1> UpdateAssessment(@RequestBody AttendanceDto attendanceDto, @PathVariable ("attendanceId")Integer attendanceId){
        try {
            String result = attendanceService.updateAttendance(attendanceId,attendanceDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", result));
        }
        catch (AssessmentNotFoundException assessmentNotFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsuccess", "ID Not Found"));
        }
    }




}
