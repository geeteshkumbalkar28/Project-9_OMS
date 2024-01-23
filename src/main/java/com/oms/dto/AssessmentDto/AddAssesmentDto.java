package com.oms.dto.AssessmentDto;

import com.oms.Entity.AddAssessment;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAssesmentDto {

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

    public AddAssesmentDto(AddAssessment addAssessment) {
        this.assessmentId = addAssessment.getAssessmentId();
        this.assesmentDate = addAssessment.getAssesmentDate();
        this.assesmentTime= addAssessment.getAssesmentTime();
        this.email= addAssessment.getEmail();
        this.firstName=addAssessment.getFirstName();
        this.lastName=addAssessment.getLastName();
        this.mobile= addAssessment.getMobile();
        this.profile=addAssessment.getProfile();
        this.result=addAssessment.getResult();
        this.sex=addAssessment.getSex();
        this.status=addAssessment.getStatus();
    }
}
