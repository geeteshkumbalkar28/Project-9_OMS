package com.oms.service;

import com.oms.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto) throws Exception;
}
