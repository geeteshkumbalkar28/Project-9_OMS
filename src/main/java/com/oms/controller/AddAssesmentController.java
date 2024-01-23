package com.oms.controller;

import com.oms.dto.AssessmentDto.AddAssesmentDto;
import com.oms.dto.AssessmentDto.ResponseAddAssessmentDTO;
import com.oms.dto.AssessmentDto.ResponseAllAssessmentDTO;
import com.oms.dto.AssessmentDto.ResponseDto1;
import com.oms.exceptions.AssesmentException.AssessmentNotFoundException;
import com.oms.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessments")
public class AddAssesmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto1> CreateAssessment(@RequestBody AddAssesmentDto addAssesmentDto)
    {
        try {
            String assessment = assessmentService.createAssessment(addAssesmentDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success",assessment)));
        }catch (AssessmentNotFoundException assessmentNotFoundException)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsucces","Assessment Not Found")));
        }
    }

    @GetMapping("/byID")
    public ResponseEntity<ResponseAddAssessmentDTO> GetAssessmentById(@RequestParam Integer assessmentId){
        try {
            ResponseAddAssessmentDTO success = new ResponseAddAssessmentDTO("success");
            AddAssesmentDto addAssesmentDto = assessmentService.GetById(assessmentId);
            success.setObject(addAssesmentDto);
            return ResponseEntity.status(HttpStatus.OK).body(success);

        }catch (AssessmentNotFoundException assessmentNotFoundException)
        {
            ResponseAddAssessmentDTO responseAddAssessmentDTO = new ResponseAddAssessmentDTO("unsuccessful");
            responseAddAssessmentDTO.setException("Assessment Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAddAssessmentDTO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllAssessmentDTO> getAllAssessment() {
        try {
            ResponseAllAssessmentDTO success = new ResponseAllAssessmentDTO("success",null);
            List<AddAssesmentDto> allAssessment = assessmentService.getAllAssessment();
            success.setList(allAssessment);
            return ResponseEntity.status(HttpStatus.OK).body(success);
        }catch (AssessmentNotFoundException assessmentNotFoundException)
        {
            ResponseAllAssessmentDTO unsuccessful = new ResponseAllAssessmentDTO("unsuccessful",null);
            unsuccessful.setException("Assessment Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(unsuccessful);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto1> deleteAssessment(@RequestParam Integer assessmentId) {
        try {
            String string = assessmentService.deleteAssessment(assessmentId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", string));
        } catch (AssessmentNotFoundException assessmentNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsucces", "Assessment Not Found"));
        }
    }

    @PatchMapping("/update/{assessmentId}")
    public ResponseEntity<ResponseDto1> UpdateAssessment(@RequestBody AddAssesmentDto addAssesmentDto, @PathVariable ("assessmentId")Integer assessmentId){
        try {
            String result = assessmentService.updateAssessment(assessmentId,addAssesmentDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", result));
        }
        catch (AssessmentNotFoundException assessmentNotFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsuccess", "ID Not Found"));
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<ResponseDto1> deleteAllAssessment() {
        try {
            String message  = assessmentService.deleteAssessmentAll();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", message ));
        } catch (AssessmentNotFoundException assessmentNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsucces", "Assessment Not Found"));
        }
    }





}
