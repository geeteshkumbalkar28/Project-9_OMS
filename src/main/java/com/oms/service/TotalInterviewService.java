package com.oms.service;


import com.oms.dto.TotalInterviewDto.TotalInterviewsDto;

import java.util.List;

public interface TotalInterviewService {

    //Post (AddInterview)
    public String addInterview(TotalInterviewsDto totalInterviews);


    //Put (Update Total Interviews)
    public String updateTotalInterviews(TotalInterviewsDto totalInterviews, Integer id);


    //GET (get All Total interview details)
    public List<TotalInterviewsDto> getAllInterview();

    //Delete (delete the TotalInterview deatils through ID)
    public String deleteInterview(Integer id);

    TotalInterviewsDto getById(Integer totalInterviewId);
}
