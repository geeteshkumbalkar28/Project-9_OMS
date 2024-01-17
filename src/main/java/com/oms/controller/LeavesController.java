package com.oms.controller;

import com.oms.dto.LeavesDto;
import com.oms.dto.ResponceDto;
import com.oms.dto.ResponseLeaveDto;

import com.oms.exceptions.LeavesNotFoundException;
import com.oms.service.LeavesInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaves")
@RequiredArgsConstructor
public class LeavesController {

    private final LeavesInterface leavesInterface;
    private Object LeavesNotFoundException;

    @PostMapping("/add")
    public ResponseEntity<?> addLeaves(@RequestBody LeavesDto leavesDto) {
        try {
            String result = leavesInterface.addLeaves(leavesDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponceDto("success",result));
        } catch (com.oms.exceptions.LeavesNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponceDto("unsuccessful", "Leaves not found"));
        }
    }

    @GetMapping("/getleave")
    public ResponseEntity<?> getLeaves(@RequestParam Integer leaveId) {

        try {
            System.out.println();
            ResponseLeaveDto responseLeaveDto = new ResponseLeaveDto("success","get interview");
            responseLeaveDto.setResponse((LeavesController) leavesInterface);
            return ResponseEntity.status(HttpStatus.OK).body(responseLeaveDto);

        } catch (LeavesNotFoundException leavesNotFoundException) {
            ResponseLeaveDto responseLeaveDto = new ResponseLeaveDto("unsuccess","Interview not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseLeaveDto);
        }

    }


    @DeleteMapping("/deleteleave")
    public ResponseEntity<?> deleteleave(@RequestParam Integer leaveId) {
        try {
            System.out.println();
            ResponceDto responceDto = new ResponceDto("success","deleted interview");
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);

        } catch (LeavesNotFoundException leavesNotFoundException) {
            ResponceDto responceDto = new ResponceDto("unsuccess","Interview not found");
            responceDto.setException(String.valueOf(LeavesNotFoundException));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responceDto);
        }
    }
    @GetMapping("/getallleave")
    public ResponseEntity<?>  getallLeave(@RequestBody Integer leaveId){
        return ResponseEntity.status(HttpStatus.OK).body(leavesInterface.getallLeave(leaveId));

    }

}
