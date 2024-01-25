package com.oms.controller;



import com.oms.dto.TotalCallsDto.CallsDeleteResponse;
import com.oms.dto.TotalCallsDto.TotalCallResponseDto;
import com.oms.dto.TotalCallsDto.TotalCallsDto;
import com.oms.dto.TotalCallsDto.TotalResponseAllCallsDTO;
import com.oms.exceptions.ExpenceException.Incorrect;
import com.oms.exceptions.TotalCallsException.SomethingHasWrong;
import com.oms.exceptions.TotalCallsException.SomethingHasWrong1;
import com.oms.service.TotalCallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Calls")
public class TotalCallsController {

    @Autowired
    public TotalCallsService totalCallsService;


//Post mapping

    @PostMapping("/addTotalCalls")
    public ResponseEntity<TotalCallResponseDto> addTotalCalls(@RequestBody TotalCallsDto totalCallsDto) {
        try {

            String s = totalCallsService.addCall(totalCallsDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new TotalCallResponseDto("Sucess", s)));
        } catch (SomethingHasWrong e) {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TotalCallResponseDto("Unsucess", "SomethingHasWrong")));
        }

    }

    @GetMapping("/getById")
    public ResponseEntity<TotalCallsDto> getById(@RequestParam Integer id) {

        try {
            TotalCallsDto byId = totalCallsService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(byId);
        } catch (Incorrect i) {
            return (ResponseEntity<TotalCallsDto>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }


//Get mapping

    @GetMapping("/getAll")
    public ResponseEntity<TotalResponseAllCallsDTO> getAll() {
        try {
            TotalResponseAllCallsDTO totalResponseAllCallsDTO = new TotalResponseAllCallsDTO("Sucessfull");
            List<TotalCallsDto> allcall = totalCallsService.getAllCalls();
            totalResponseAllCallsDTO.setList(allcall);

            return ResponseEntity.status(HttpStatus.OK).body(totalResponseAllCallsDTO);
        } catch (SomethingHasWrong s) {

            TotalResponseAllCallsDTO totalResponseAllCallsDTO1 = new TotalResponseAllCallsDTO("Unsucessfull");
            totalResponseAllCallsDTO1.setException("SomthingHasWrong");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(totalResponseAllCallsDTO1);

        }
    }


//Put Mapping (for Update Total calls Details By Id)

    @PutMapping("/updateTotalCallsById")
    public ResponseEntity<TotalCallResponseDto> updateTotalCallsById(@RequestParam Integer Id, @RequestBody TotalCallsDto newTotalCallsDto) {
        try {
            String s = totalCallsService.updateTotalCalls(newTotalCallsDto, Id);
            return ResponseEntity.status(HttpStatus.OK).body(new TotalCallResponseDto("sucess", s));
        } catch (SomethingHasWrong e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TotalCallResponseDto("Unsucess", "Id"));
        }
    }


//Delete Mapping (Delete Total calls Details By Id)

    @DeleteMapping("/DeleteTotalCallsById")
    public ResponseEntity<?> DeleteTotalCallsById(@RequestParam Integer id) {

        try {

            CallsDeleteResponse callsDeleteResponse = new CallsDeleteResponse("Sucessfull");
            callsDeleteResponse.setResponse(totalCallsService.deleteCalls(id));
            return ResponseEntity.status(HttpStatus.OK).body(callsDeleteResponse);
        } catch (SomethingHasWrong1 somethingHasWrong1) {
            CallsDeleteResponse callsDeleteResponse = new CallsDeleteResponse("Unsucessfull");
            callsDeleteResponse.setException(String.valueOf(somethingHasWrong1));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(callsDeleteResponse);
        }
    }
}












