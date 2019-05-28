package com.event.backoffice.rest;

import com.event.backoffice.dto.FAQDto;
import com.event.backoffice.dto.PolyclinicsDto;
import com.event.backoffice.dto.UserDto;
import com.event.backoffice.model.Polyclinics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(value = "Main api",
        description = "Main page of application",
        produces = APPLICATION_JSON_UTF8_VALUE)
public interface MainAPI {

    @ApiOperation(value = "Get data from DataBase")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    String getData();

    @ApiOperation(value = "Get UserDto from DataBase")
    @ApiResponse(code = 200, message = "User was successfully get", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    UserDto getUser();

    @ApiOperation(value = "Get FAQ from DataBase")
    @ApiResponse(code = 200, message = "FAQ was successfully get", response = FAQDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    FAQDto getFAQ();

    @ApiOperation(value = "Get Polyclinic from DataBase")
    @ApiResponse(code = 200, message = "Polyclinic was successfully get", response = PolyclinicsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    PolyclinicsDto getPolyclinic();

    @ApiOperation(value = "Get All Polyclinics from DataBase")
    @ApiResponse(code = 200, message = "All Polyclinics was successfully get", response = PolyclinicsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    List<PolyclinicsDto> getPolyclinics();
}
