package com.oms.Entity;


import com.oms.dto.Userprofile.UserProfileDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {

    @Id
    @Column(name = "User_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private String qualification;

    @Column
    private int totalYearOfExperience;

    @Column
    private int relevantExperience;

    @Column
    private String previousCompany;

    @Column
    private OffsetDateTime joiningDate;

    @Column
    private String domain;


    //Constructor


    public UserProfile(UserProfileDto userProfileDto) {

        this.userId = userProfileDto.getUserId();
        this.firstName = userProfileDto.getFirstName();
        this.lastName = userProfileDto.getLastName();
        this.age = userProfileDto.getAge();
        this.qualification = userProfileDto.getQualification();
        this.totalYearOfExperience = userProfileDto.getTotalYearOfExperience();
        this.relevantExperience = userProfileDto.getRelevantExperience();
        this.previousCompany = userProfileDto.getPreviousCompany();
        this.joiningDate = userProfileDto.getJoiningDate();
        this.domain = userProfileDto.getDomain();
    }


}

