package com.oms.service;


import com.oms.dto.Userprofile.UserProfileDto;

import java.util.List;

public interface UserProfileService {


    String addUserProfile(UserProfileDto userProfileDto);

    String updateUserProfile(UserProfileDto newuserProfileDto, Integer id);


    List<UserProfileDto> getAllUserProfile(int pageNo, int pageSize);


    //get by id
    UserProfileDto getById(Integer userId);


    String deleteUserProfile(Integer userId);
}
