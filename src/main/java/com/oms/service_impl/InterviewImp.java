package com.oms.service_impl;

import com.oms.Entity.Interview;
import com.oms.dto.InterviewDto;
import com.oms.exceptions.InterviewNotFoundException;
import com.oms.repositories.InterviewRepository;
import com.oms.service.Iinterview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public  class InterviewImp implements Iinterview {

    private final InterviewRepository interviewRepository;


    @Override
    public String addinterview(InterviewDto interviewDto) {

        Interview interview1 = new Interview();
        interview1.setFirstName(interviewDto.firstName);
        interview1.setLastName(interviewDto.lastName);
        interview1.setInterviewTime(interviewDto.interviewTime);
        interview1.setInterviewDate(interviewDto.interviewDate);
        interview1.setGender(interviewDto.gender);
        interview1.setDate(interviewDto.date);
        interview1.setEmail(interviewDto.email);
        interview1.setLocation(interviewDto.location);
        interview1.setMobileNo(interviewDto.mobileNo);
        interview1.setMode(interviewDto.mode);
        interview1.setProfile(interviewDto.profile);

        interviewRepository.save(interview1);


        return "Interview Added successfully";
    }


    @Override
    public Interview getinterview(Integer interviewId) {
        Optional<Interview> interviewController = interviewRepository.findById(interviewId);
        if(interviewController.isEmpty()){throw new InterviewNotFoundException("Interview not found by Id");
        }
        return interviewController.get();
    }

    @Override
    public String deleteinterview(Integer interviewId) {
        Optional<Interview> interviewController = interviewRepository.findById(interviewId);
        if(interviewController.isEmpty()){throw new InterviewNotFoundException("Interview not found by Id");
        }
        interviewRepository.deleteById(interviewId);
        return "deleted interview";
    }
    @Override
    public List<Interview> getallInterview() {
        return interviewRepository.findAll();
    }


}
