package com.oms.controller;

import com.oms.dto.UserDto;
import com.oms.exceptions.*;
import com.oms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;


    @PutMapping("/update-user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Integer userId, @RequestBody UserDto userDto){
        try {
            UserDto userDto1 = this.userService.updateUser(userDto, userId);
            return new ResponseEntity<>(userDto1, HttpStatus.OK);
        } catch (UserDisabledException e) {
            throw new UserAlreadyExistException("User disabled");
        }catch (UserNotFoundException e) {
            throw new UserNotFoundException("User not found");
        }
    }



    @GetMapping("/get/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer userId){

        if (userId!=null) {
            try {
                UserDto userById = this.userService.getUserById(userId);
                return new ResponseEntity<>(userById, HttpStatus.OK);
            } catch (UserDisabledException e) {
                throw new UserAlreadyExistException("User disabled");
            }catch (UserNotFoundException e) {
                throw new UserNotFoundException("User not found");
            }
        } else {
            throw new ValueNotNullException("Value should not be null");
        }
    }

    @GetMapping("get-all-users/{page}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsers(@PathVariable("page")Integer page) throws PageNotFoundException, TaskNotFoundException {
        List<UserDto> allUsers = this.userService.findAllUsers(page);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable("userId")Integer userId){
        try {
            this.userService.deleteUserById(userId);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user: " + e.getMessage());
        }
    }

}
