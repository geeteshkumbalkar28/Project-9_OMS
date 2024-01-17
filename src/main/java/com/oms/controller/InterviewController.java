package com.oms.controller;

import com.oms.Entity.Interview;
import com.oms.dto.InterviewDto;
import com.oms.dto.ResponceDto;
import com.oms.dto.ResponseDto;
import com.oms.exceptions.InterviewNotFoundException;
import com.oms.service.Iinterview;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/interview")
@RestController
@RequiredArgsConstructor
public class InterviewController {

    private final Iinterview iinterview;
    private Object InterviewNotFoundException;


    @PostMapping("/add")
    public ResponseEntity<ResponceDto> addInterview(@RequestBody InterviewDto interviewDto) {
        try {
            String result = iinterview.addinterview(interviewDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponceDto("success", result));
        } catch (com.oms.exceptions.InterviewNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponceDto("unsuccessful", "Interview not found"));
        }
    }

    @GetMapping("/getinterview")
    public ResponseEntity<?> getinterview(@RequestParam Integer interviewId) {

        try {
            System.out.println();
            ResponceDto responceDto = new ResponceDto("success", "get interview");
            Interview i
                    = iinterview.getinterview(interviewId);
            responceDto.setResponse(i);
            System.out.println(i.toString());
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);

        } catch (InterviewNotFoundException interviewException) {
            ResponceDto responceDto = new ResponceDto("unsuccess", "Interview not found");
            responceDto.setException(String.valueOf(InterviewNotFoundException));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responceDto);
        }

    }


    @DeleteMapping("/deleteinterview")
    public ResponseEntity<?> deleteInterview(@RequestParam Integer interviewId) {
        try {

            ResponseDto responceDto = new ResponseDto("success");
            responceDto.setResponse(iinterview.deleteinterview(interviewId));
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);

        } catch (InterviewNotFoundException interviewException) {
            ResponceDto responceDto = new ResponceDto("unsuccess", "Interview not found");
            responceDto.setException(interviewException.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responceDto);
        }
    }


    @GetMapping("/getallinterview")
    public ResponseEntity<?> getallInterview() {
        return ResponseEntity.status(HttpStatus.OK).body(iinterview.getallInterview());

    }


}
