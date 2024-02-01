package com.oms.dto.Userprofile;


import com.oms.Entity.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto {

    private int userId;


    private String firstName;
    private String lastName;
    private int age;
    private String qualification;
    private int totalYearOfExperience;
    private int relevantExperience;
    private String previousCompany;
    private OffsetDateTime joiningDate;
    private String domain;


    //Dto to Entity
    public UserProfileDto(UserProfile userProfile) {
        this.userId = userProfile.getUserId();
        this.firstName = userProfile.getFirstName();
        this.lastName = userProfile.getLastName();
        this.age = userProfile.getAge();
        this.qualification = userProfile.getQualification();
        this.totalYearOfExperience = userProfile.getTotalYearOfExperience();
        this.relevantExperience = userProfile.getRelevantExperience();
        this.previousCompany = userProfile.getPreviousCompany();
        this.joiningDate = userProfile.getJoiningDate();
        this.domain = userProfile.getDomain();
    }

}
