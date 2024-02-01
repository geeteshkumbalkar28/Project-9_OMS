package com.oms.service_impl;


import com.oms.Entity.TotalCalls;
import com.oms.dto.TotalCallsDto.TotalCallsDto;
import com.oms.exceptions.ExpenceException.Incorrect;
import com.oms.exceptions.TotalCallsException.SomethingHasWrong;
import com.oms.exceptions.TotalCallsException.SomethingHasWrong1;
import com.oms.repositories.TotalCallsRepository;
import com.oms.service.TotalCallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TotalCallsServiceImpl implements TotalCallsService {

    @Autowired
    public TotalCallsRepository totalCallsRepository;


    //PostMapping (for Add call)
    @Override
    public String addCall(TotalCallsDto totalCallsDto) {
        TotalCalls totalCalls = new TotalCalls(totalCallsDto);

        totalCallsRepository.save(totalCalls);
        return "TotalCall details added successfully";
    }


    //GetMapping( for get all calls)
    @Override
    public List<TotalCallsDto> getAllCalls() {
        List<TotalCalls> all = totalCallsRepository.findAll();
        return all.stream().map(TotalCallsDto::new).collect(Collectors.toList());

    }


    //PutMapping for update Total Calls Details
    @Override
    public String updateTotalCalls(TotalCallsDto totalCallsDto, Integer id) {
        TotalCalls totalCalls1 = totalCallsRepository.findById(id).orElseThrow(() -> new SomethingHasWrong("TotalCallsNotFound", HttpStatus.NOT_FOUND));

        if (totalCallsDto.getAssignedTo() != null) {
            totalCalls1.setAssignedTo(totalCallsDto.getAssignedTo());
        }
        if (totalCallsDto.getCalls() != null) {
            totalCalls1.setCalls(totalCallsDto.getCalls());
        }
        if (totalCallsDto.getDate() != null) {
            totalCalls1.setDate(totalCallsDto.getDate());
        }
        if (totalCallsDto.getEndDate() != null) {
            totalCalls1.setEndDate(totalCallsDto.getEndDate());
        }
        if (totalCallsDto.getMessage() != null) {
            totalCalls1.setMessage(totalCallsDto.getMessage());
        }
        if (totalCallsDto.getStatus() != null) {
            totalCalls1.setStatus(totalCallsDto.getStatus());
        }
        if (totalCallsDto.getTask() != null) {
            totalCalls1.setTask(totalCallsDto.getTask());
        }
        if (totalCallsDto.getTotalCall() != null) {
            totalCalls1.setTotalCall(totalCallsDto.getTotalCall());
        }
        if (totalCallsDto.getTotalCallAttended() != null) {
            totalCalls1.setTotalCallAttended(totalCallsDto.getTotalCallAttended());
        }
        if (totalCallsDto.getTotalPeopleConsulted() != null) {
            totalCalls1.setTotalPeopleConsulted(totalCallsDto.getTotalPeopleConsulted());
        }
        if (totalCallsDto.getTotalReplies() != null) {
            totalCalls1.setTotalReplies(totalCallsDto.getTotalReplies());
        }
        totalCallsRepository.save(totalCalls1);
        return "TotalCalls Updated";

    }


    //DeleteMapping (For delete calls by id)
    @Override
    public String deleteCalls(Integer id) {
        Optional<TotalCalls> byId = totalCallsRepository.findById(id);
        if (byId.isPresent()) {
            totalCallsRepository.deleteById(id);
            return "call details deleted sucessfully";
        } else {
            throw new SomethingHasWrong1("Call Id Not Found");
        }


    }

    @Override
    public TotalCallsDto getById(Integer id) {
        Optional<TotalCalls> byId = totalCallsRepository.findById(id);
        if (byId.isPresent()) {
            TotalCallsDto totalCallsDto = new TotalCallsDto(byId.get());
            totalCallsDto.setId(id);
            return totalCallsDto;
        } else {
            throw new Incorrect("Total calls Not Found", HttpStatus.NOT_FOUND);
        }
    }


}


