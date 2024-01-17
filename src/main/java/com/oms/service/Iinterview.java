package com.oms.service;

import com.oms.Entity.Interview;
import com.oms.dto.InterviewDto;

import java.util.List;

public interface Iinterview {

    public String addinterview(InterviewDto interviewDto);
    public Interview getinterview(Integer interviewId);
    public String deleteinterview(Integer interviewId);
    public List<Interview> getallInterview();



}