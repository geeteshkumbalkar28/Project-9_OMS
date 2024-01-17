package com.oms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AddAssessment {

    @Id
    @Column(name= "assessment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interviewId;

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

}