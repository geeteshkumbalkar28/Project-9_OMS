package com.oms.service;


import com.oms.dto.TotalCallsDto.TotalCallsDto;

import java.util.List;

public interface TotalCallsService {


    //@Post  ( Add Total Calls Details)
    public String addCall(TotalCallsDto totalCallsDto);


    //@Put (for Update Total calls details)
    public String updateTotalCalls(TotalCallsDto TotalCallsDto, Integer id);


    //@Get  (Get All Total Calls details)
    public List<TotalCallsDto> getAllCalls();


    //@Delete (To Delete Total Calls details)
    public String deleteCalls(Integer id);


    TotalCallsDto getById(Integer id);
}

