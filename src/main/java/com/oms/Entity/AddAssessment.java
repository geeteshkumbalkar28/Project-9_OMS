package com.oms.Entity;

import com.oms.dto.AssessmentDto.AddAssesmentDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.OffsetDateTime;


@Entity
@Getter
@Setter
public class AddAssessment {

    @Id
    @Column(name= "assessment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assessmentId;

    @Column
    private OffsetDateTime assesmentDate;

    @Column
    private LocalTime assesmentTime;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String mobile;

    @Column
    private String profile;

    @Column(nullable = false)
    private Boolean result;

    @Column
    private String sex;

    @Column(nullable = false)
    private Boolean status;


    public AddAssessment() {
    }

    public AddAssessment(AddAssesmentDto addAssesmentDto) {
        this.assesmentDate=addAssesmentDto.getAssesmentDate();
        this.assesmentTime=addAssesmentDto.getAssesmentTime();
        this.email= addAssesmentDto.getEmail();
        this.firstName= addAssesmentDto.getFirstName();
        this.lastName= addAssesmentDto.getLastName();
        this.mobile= addAssesmentDto.getMobile();
        this.profile= addAssesmentDto.getMobile();
        this.result=addAssesmentDto.getResult();
        this.sex= addAssesmentDto.getSex();
        this.status=addAssesmentDto.getStatus();
        this.assessmentId=addAssesmentDto.getAssessmentId();
    }}