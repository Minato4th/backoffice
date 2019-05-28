package com.event.backoffice.rest;

import com.event.backoffice.dto.UserDto;
import com.event.backoffice.dto.UserPostDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(value = "User API",
        description = "User end points of application",
        produces = APPLICATION_JSON_UTF8_VALUE)
public interface UserAPI {

    @ApiOperation(value = "Post request for external API that save user in base if needed and send userDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    UserDto loggInUser(@NotNull @Valid @RequestBody UserPostDto userPostDto);
}
