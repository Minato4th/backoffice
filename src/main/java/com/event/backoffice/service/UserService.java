package com.event.backoffice.service;

import com.event.backoffice.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAllUsers();

    UserDto findUserById(Long Id);

    void saveInBaseIfNeed(UserDto userDto);
}
