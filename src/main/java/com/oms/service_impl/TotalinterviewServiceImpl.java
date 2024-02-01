package com.oms.service_impl;

import com.oms.Entity.TotalInterviews;


import com.oms.dto.TotalInterviewDto.TotalInterviewsDto;

import com.oms.exceptions.TotalInterviewException.Somethingwentwrong;
import com.oms.exceptions.TotalInterviewException.Somethingwentwrong1;

import com.oms.repositories.TotalInterviewsRepository;
import com.oms.service.TotalInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TotalinterviewServiceImpl implements TotalInterviewService {

    @Autowired
    public TotalInterviewsRepository totalInterviewsRepository;


    //PostMapping (for Add Interview)
    @Override
    public String addInterview(TotalInterviewsDto totalInterviews) {
        TotalInterviews totalInterviews1 = new TotalInterviews(totalInterviews);

        totalInterviewsRepository.save(totalInterviews1);
        return "Totalinterview added successfully";
    }


    //Post Mapping(for update)
    @Override
    public String updateTotalInterviews(TotalInterviewsDto totalInterviews, Integer id) {

        TotalInterviews totalInterviews1 = totalInterviewsRepository.findById(id).orElseThrow(() -> new Somethingwentwrong("TotalInterviewnotFound", HttpStatus.NOT_FOUND));

        if (totalInterviews.getDate() != null) {
            totalInterviews1.setDate(totalInterviews.getDate());
        }

        if (totalInterviews.getStatus() != null) {
            totalInterviews1.setStatus(totalInterviews.getStatus());
        }

        if (totalInterviews.getTotalCallAttend() != null) {
            totalInterviews1.setTotalCallAttend(totalInterviews.getTotalCallAttend());
        }

        if (totalInterviews.getTotalReplies() != null) {
            totalInterviews1.setTotalReplies(totalInterviews.getTotalReplies());
        }

        totalInterviewsRepository.save(totalInterviews1);
        return "TotalInterview Updated";
    }

    @Override
    public List<TotalInterviewsDto> getAllInterview() {
        List<TotalInterviews> all = totalInterviewsRepository.findAll();
        if (all.isEmpty()) {
            throw new Somethingwentwrong("totalInterview Not Found", null);
        }
        return all.stream().map(TotalInterviewsDto::new).collect(Collectors.toList());
    }

    @Override
    public String deleteInterview(Integer id) {
        Optional<TotalInterviews> byId = totalInterviewsRepository.findById(id);
        if (byId.isPresent()) {
            totalInterviewsRepository.deleteById(id);
            return "interview Deleted Successfully";

        } else {
            throw new Somethingwentwrong1("Interview Id Not Found");
        }

    }


    @Override
    public TotalInterviewsDto getById(Integer interviewId) {
        Optional<TotalInterviews> byId = totalInterviewsRepository.findById(interviewId);
        if (byId.isPresent()) {
            TotalInterviewsDto totalInterviewsDto = new TotalInterviewsDto(byId.get());
            totalInterviewsDto.setInterviewId(interviewId);
            return totalInterviewsDto;
        } else {
            throw new Somethingwentwrong1("Total Interview Not Found");
        }


    }


}

