package com.oms.service;


import com.oms.dto.AssessmentDto.AddAssesmentDto;

import java.util.List;

public interface AssessmentService {

    public String createAssessment(AddAssesmentDto addAssesmentDto);

    public AddAssesmentDto GetById(Integer assessmentId);


    public List<AddAssesmentDto> getAllAssessment();


    String deleteAssessment(Integer assessmentId);


    String updateAssessment(Integer assessmentId, AddAssesmentDto addAssesmentDto);

    String deleteAssessmentAll();
}
