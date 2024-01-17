package com.oms.service;

import com.oms.Entity.Users;
import com.oms.dto.UserDto;
import com.oms.exceptions.PageNotFoundException;
import com.oms.exceptions.TaskNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto) throws Exception;
    UserDto getUserById(Integer userId);

    public UserDto updateUser(UserDto userDto, Integer userId);

    List<UserDto>  findAllUsers(Integer id) throws PageNotFoundException, TaskNotFoundException;

    public void deleteUserById(Integer userId);
}
