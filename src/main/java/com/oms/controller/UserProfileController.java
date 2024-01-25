package com.oms.controller;


import com.oms.dto.Userprofile.AllResponseUserProfileDto;
import com.oms.dto.Userprofile.UserProfileDeleteResponse;
import com.oms.dto.Userprofile.UserProfileDto;
import com.oms.dto.Userprofile.UserProfileResponseDto;
import com.oms.exceptions.UserProfileException.Inaccurate25;
import com.oms.exceptions.UserProfileException.Inaccurate;
import com.oms.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/UserProfile")
@RestController
public class UserProfileController {


    @Autowired
    public UserProfileService userProfileService;


    //PostMapping(add)
    @PostMapping("/addUserProfile")
    public ResponseEntity<UserProfileResponseDto> addUserProfile(@RequestBody UserProfileDto userProfileDto) {

        try {
            String s = userProfileService.addUserProfile(userProfileDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new UserProfileResponseDto("Sucess", s)));
        } catch (Inaccurate i) {
            return (ResponseEntity.status(HttpStatus.OK).body(new UserProfileResponseDto("Unsucess", "Inaccurate")));
        }
    }


    //Put Mapping
    @PutMapping("/UpdateUserProfileById/{Id}")
    public ResponseEntity<UserProfileResponseDto> UpdateUserProfileById(@PathVariable Integer Id, @RequestBody UserProfileDto newuserProfileDto) {
        try {
            String s = userProfileService.updateUserProfile(newuserProfileDto, Id);
            return ResponseEntity.status(HttpStatus.OK).body(new UserProfileResponseDto("Sucess", s));
        } catch (Inaccurate i) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserProfileResponseDto("Unsucessfull", "IDNOTFOUND"));
        }
    }


    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Integer userId) {


        try {
            UserProfileDto byId = userProfileService.getById(userId);
            return ResponseEntity.status(HttpStatus.OK).body(byId);
        } catch (Inaccurate i) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserProfile Not Found");
        }
    }


    //Get Mapping
    @GetMapping("/getAll")
    public ResponseEntity<AllResponseUserProfileDto> getAll(@RequestParam int pageNo,
                                                            @RequestParam(value = " pagesize", defaultValue = "10") int pageSize) {

        try {
            AllResponseUserProfileDto allResponseUerProfileDto1 = new AllResponseUserProfileDto("Sucessfull");
            List<UserProfileDto> allUserProfiles = userProfileService.getAllUserProfile(pageNo, pageSize);

            if (allUserProfiles.isEmpty()) {
                allResponseUerProfileDto1.setMessage("Unsucess");
                allResponseUerProfileDto1.setException("page not found");
            } else {

                allResponseUerProfileDto1.setList(allUserProfiles);
            }

            return ResponseEntity.status(HttpStatus.OK).body(allResponseUerProfileDto1);
        } catch (Inaccurate i) {
            AllResponseUserProfileDto allResponseUserProfileDto = new AllResponseUserProfileDto("Unsucessfull");
            allResponseUserProfileDto.setException("No User Profile data found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allResponseUserProfileDto);
        }
    }

    @DeleteMapping("/deleteUserProfileData")
    public ResponseEntity<?> deleteUserProfileData(@RequestParam Integer userId) {
        try {

            UserProfileDeleteResponse responceDto = new UserProfileDeleteResponse("successfully Deleted");
//            responceDto.setResponse
            userProfileService.deleteUserProfile(userId);
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);

        } catch (Inaccurate25 interviewException) {
            UserProfileDeleteResponse responceDto1 = new UserProfileDeleteResponse("User Profile Id not Found");
            responceDto1.setException(interviewException.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responceDto1);
        }
    }


}
