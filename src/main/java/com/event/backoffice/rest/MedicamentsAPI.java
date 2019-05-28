package com.event.backoffice.rest;

import com.event.backoffice.dto.MedicamentsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(value = "Medicaments API",
        description = "Medicaments end points of application",
        produces = APPLICATION_JSON_UTF8_VALUE)
public interface MedicamentsAPI {

    @ApiOperation(value = "Get all Medicaments from DataBase")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = MedicamentsDto.class),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    List<MedicamentsDto> getMedicaments();
}
