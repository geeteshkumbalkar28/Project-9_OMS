package com.oms.service_impl;


import com.oms.Entity.UserProfile;
import com.oms.dto.Userprofile.UserProfileDto;
import com.oms.exceptions.ExpenceException.Incorrect;
import com.oms.exceptions.UserProfileException.Inaccurate25;
import com.oms.exceptions.UserProfileException.Inaccurate;
import com.oms.repositories.UserProfileRepository;
import com.oms.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    public UserProfileRepository userProfileRepository;


    //Post Mapping
    @Override
    public String addUserProfile(UserProfileDto userProfileDto) {

        UserProfile userProfile = new UserProfile(userProfileDto);

        userProfileRepository.save(userProfile);
        return "User Profile Added Sucessfully";


    }

    @Override
    public String updateUserProfile(UserProfileDto newuserProfileDto, Integer id) {
        Optional<UserProfile> byId = userProfileRepository.findById(id);
        if (byId.isPresent()) {
            UserProfile userProfile = byId.get();
            userProfile.setFirstName(newuserProfileDto.getFirstName());
            userProfile.setLastName(newuserProfileDto.getLastName());
            userProfile.setAge(newuserProfileDto.getAge());
            userProfile.setQualification(newuserProfileDto.getQualification());
            userProfile.setTotalYearOfExperience(newuserProfileDto.getTotalYearOfExperience());
            userProfile.setRelevantExperience(newuserProfileDto.getRelevantExperience());
            userProfile.setPreviousCompany(newuserProfileDto.getPreviousCompany());
            userProfile.setJoiningDate(newuserProfileDto.getJoiningDate());
            userProfile.setDomain(newuserProfileDto.getDomain());

            userProfileRepository.save(userProfile);
            return "UserProfile Updated Sucessfully";

        } else {
            throw new Incorrect("IDNOTFOUND", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public List<UserProfileDto> getAllUserProfile(int pageNo, int pagesize) {

        PageRequest pageRequest = PageRequest.of(pageNo, pagesize);

        if (pageRequest.isPaged()) {

            Page<UserProfile> userProfiles = userProfileRepository.findAll(pageRequest);


            List<UserProfileDto> all = new ArrayList<>();

            for (UserProfile userProfile : userProfiles) {
                UserProfileDto userProfileDto = new UserProfileDto(userProfile);
                all.add(userProfileDto);
            }
            return all;
        } else {
            throw new Inaccurate("Resource Not Found", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public UserProfileDto getById(Integer userId) {
        Optional<UserProfile> byId = userProfileRepository.findById(userId);
        if (byId.isPresent()) {
            UserProfileDto userProfileDto = new UserProfileDto(byId.get());
            userProfileDto.setUserId(userId);
            return userProfileDto;
        } else {
            throw new Inaccurate("User Profile Not Found", HttpStatus.NOT_FOUND);
        }


    }

    @Override
    public String deleteUserProfile(Integer userId) {

        Optional<UserProfile> byId = userProfileRepository.findById(userId);
        if (byId.isEmpty()) {
            throw new Inaccurate25("UserProfile not found by Id");
        }
        userProfileRepository.deleteById(userId);
        return "deleted UserProfileData";
    }


}




