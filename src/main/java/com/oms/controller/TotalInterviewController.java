package com.oms.controller;


import com.oms.dto.TotalInterviewDto.InterviewDeleteResponse;
import com.oms.dto.TotalInterviewDto.TotalInterviewResponseDto;
import com.oms.dto.TotalInterviewDto.TotalInterviewsDto;
import com.oms.dto.TotalInterviewDto.TotalResponseAllInterviewDto;
import com.oms.exceptions.TotalInterviewException.Somethingwentwrong;
import com.oms.exceptions.TotalInterviewException.Somethingwentwrong1;
import com.oms.service.TotalInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TotalInterviewController {

    @Autowired
    public TotalInterviewService totalInterviewService;


    //Post Mapping (To add the Total Interview details)
    @PostMapping("/addTotalInterviews")
    public ResponseEntity<TotalInterviewResponseDto> addTotalInterviews(@RequestBody TotalInterviewsDto totalInterviews) {

        try {
            String s = totalInterviewService.addInterview(totalInterviews);
            return (ResponseEntity.status(HttpStatus.OK).body(new TotalInterviewResponseDto("sucess", s)));


        } catch (Somethingwentwrong e) {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TotalInterviewResponseDto("Unscess", "Somethingwentwrong")));

        }
    }


    //Put Mapping (For update Total Interview Details)
    @PutMapping("/updateTotalInterviewsById/{Id}")
    public ResponseEntity<TotalInterviewResponseDto> updateTotalInterviewsById(@PathVariable Integer Id, @RequestBody TotalInterviewsDto newTotalInterviewsDto) {
        try {
            String s = totalInterviewService.updateTotalInterviews(newTotalInterviewsDto, Id);
            return ResponseEntity.status(HttpStatus.OK).body(new TotalInterviewResponseDto("Sucess", s));

        } catch (Somethingwentwrong e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TotalInterviewResponseDto("unsucess", "IdNotFound"));
        }

    }


    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Integer interviewId) {

        try {
            TotalInterviewsDto byId = totalInterviewService.getById(interviewId);
            return ResponseEntity.status(HttpStatus.OK).body(byId);
        } catch (Somethingwentwrong e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TotalInterviews Not Found");
        }
    }


    //Get Mapping (To Get the All details of TotalInterview)
    @GetMapping("/getAll")
    public ResponseEntity<TotalResponseAllInterviewDto> getAll() {
        try {
            TotalResponseAllInterviewDto totalResponseAllInterviewDto = new TotalResponseAllInterviewDto("Sucessfull");
            List<TotalInterviewsDto> allInterview = totalInterviewService.getAllInterview();
            totalResponseAllInterviewDto.setList(allInterview);

            return ResponseEntity.status(HttpStatus.OK).body(totalResponseAllInterviewDto);
        } catch (Somethingwentwrong e) {
            TotalResponseAllInterviewDto totalResponseAllInterviewDto1 = new TotalResponseAllInterviewDto("Unsucessfull");
            totalResponseAllInterviewDto1.setException("No Interview Data found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(totalResponseAllInterviewDto1);

        }
    }


    //Delete Mapping ( for Delete the Total Interview Details by Id)
    @DeleteMapping("/DeleteTotalInterviewsById")
    public ResponseEntity<?> DeleteTotalInterviewsById(@RequestParam Integer id) {

        try {
            InterviewDeleteResponse interviewDeleteResponse = new InterviewDeleteResponse("Sucessfull");
            interviewDeleteResponse.setResponse(totalInterviewService.deleteInterview(id));
            return ResponseEntity.status(HttpStatus.OK).body(interviewDeleteResponse);
        } catch (Somethingwentwrong1 somethingwentwrong1) {
            InterviewDeleteResponse interviewDeleteResponse = new InterviewDeleteResponse("UnSucessfull");
            interviewDeleteResponse.setException(String.valueOf(somethingwentwrong1));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(interviewDeleteResponse);
        }

    }
}
