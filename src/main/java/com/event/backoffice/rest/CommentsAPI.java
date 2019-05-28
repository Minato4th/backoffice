package com.event.backoffice.rest;

import com.event.backoffice.dto.CommentsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(value = "Comments API",
        description = "Comments end points of application",
        produces = APPLICATION_JSON_UTF8_VALUE)
public interface CommentsAPI {

    @ApiOperation(value = "Save Comments to DataBase for specified Polyclinic Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    void saveCommentsById(@PathVariable Long polyclinicId,
                          @NotNull @Valid @RequestBody CommentsDto commentsDto);

    @ApiOperation(value = "Return Comments from DataBase for specified Polyclinic Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something go wrong")
    })
    List<CommentsDto> getCommentsById(@PathVariable Long polyclinicId);
}
