package com.event.backoffice.rest.controllers;

import com.event.backoffice.dto.UserDto;
import com.event.backoffice.dto.UserGetDto;
import com.event.backoffice.dto.UserPostDto;
import com.event.backoffice.rest.UserAPI;
import com.event.backoffice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class UserController implements UserAPI {

    private final RestTemplate restTemplate;

    private final UserService userService;

    @Override
    @PostMapping(path = "api/user/logging")
    public UserDto loggInUser(@NotNull @Valid @RequestBody UserPostDto userPostDto) {

        final UserGetDto userGetDto = restTemplate.postForObject("https://am-week.herokuapp.com/api/user/login",
                userPostDto,
                UserGetDto.class);

        final UserDto userDto = UserDto.builder()
                .userName(userGetDto.getUser().getName())
                .email(userGetDto.getUser().getEmail())
                .build();

        userService.saveInBaseIfNeed(userDto);

        return userDto;
    }
}
