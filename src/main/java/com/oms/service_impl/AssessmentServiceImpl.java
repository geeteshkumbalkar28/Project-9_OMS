package com.oms.service_impl;

import com.oms.Entity.AddAssessment;
import com.oms.dto.AssessmentDto.AddAssesmentDto;
import com.oms.exceptions.AssesmentException.AssessmentNotFoundException;
import com.oms.repositories.AddAssessmentRepository;
import com.oms.service.AssessmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    AddAssessmentRepository addAssessmentRepository;


    @Override
    public String createAssessment(AddAssesmentDto addAssesmentDto) {
        AddAssessment addAssessment = new AddAssessment(addAssesmentDto);
        addAssessmentRepository.save(addAssessment);
        return "Assessment Added Successfully";
    }

    @Override
    public AddAssesmentDto GetById(Integer assessmentId) {
        Optional<AddAssessment> byId = addAssessmentRepository.findById(assessmentId);
        if (byId.isEmpty()){
            throw new AssessmentNotFoundException("Assessment NOt Found", HttpStatus.NOT_FOUND);
        }
        AddAssesmentDto addAssesmentDto = new AddAssesmentDto(byId.get());
        addAssesmentDto.setAssessmentId(assessmentId);
        return addAssesmentDto;
    }

    @Override
    public List<AddAssesmentDto> getAllAssessment() {
        List<AddAssessment> all = addAssessmentRepository.findAll();
        if (all.isEmpty()){
            throw new AssessmentNotFoundException("Assesment not found");
        }
        return all.stream().map(AddAssesmentDto::new).collect(Collectors.toList());
    }



    @Override
    public String deleteAssessment(Integer assessmentId) {
        AddAssesmentDto addAssesmentDto = GetById(assessmentId);
        if (addAssesmentDto == null){
            throw new AssessmentNotFoundException("Assessment Not Found");
        }
        addAssessmentRepository.deleteById(assessmentId);
        return "Assessment Deleted Successfully";
    }

    @Override
    public String updateAssessment(Integer assessmentId, AddAssesmentDto addAssesmentDto) {
        AddAssessment addAssessment = addAssessmentRepository.findById(assessmentId).orElseThrow(() -> new AssessmentNotFoundException("Assessment Not Found", HttpStatus.NOT_FOUND));


        if (addAssesmentDto.getAssesmentDate() != null) {
            addAssessment.setAssesmentDate(addAssesmentDto.getAssesmentDate());
        }
        if (addAssesmentDto.getAssesmentTime() != null) {
            addAssessment.setAssesmentTime(addAssesmentDto.getAssesmentTime());
        }
        if (addAssesmentDto.getEmail() != null) {
            addAssessment.setEmail(addAssesmentDto.getEmail());
        }
        if (addAssesmentDto.getFirstName() != null) {
            addAssessment.setFirstName(addAssesmentDto.getFirstName());
        }
        if (addAssesmentDto.getLastName() != null) {
            addAssessment.setLastName(addAssesmentDto.getLastName());
        }
        if (addAssesmentDto.getMobile() != null) {
            addAssessment.setMobile(addAssesmentDto.getMobile());
        }
        if (addAssesmentDto.getProfile() != null) {
            addAssessment.setProfile(addAssesmentDto.getProfile());
        }
        if (addAssesmentDto.getResult() != null) {
            addAssessment.setResult(addAssesmentDto.getResult());
        }
        if (addAssesmentDto.getSex() != null) {
            addAssessment.setSex(addAssesmentDto.getSex());
        }
        if (addAssesmentDto.getStatus() != null) {
            addAssessment.setStatus(addAssesmentDto.getStatus());
        }

        addAssessmentRepository.save(addAssessment);
        return "Assessment Updated";
    }

    @Transactional
    @Override
    public String deleteAssessmentAll() {
        addAssessmentRepository.deleteAll();
        return "All Assessment Data Deleted Successfully";
    }


}
