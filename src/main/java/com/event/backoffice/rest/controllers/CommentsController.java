package com.event.backoffice.rest.controllers;

import com.event.backoffice.dto.CommentsDto;
import com.event.backoffice.rest.CommentsAPI;
import com.event.backoffice.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class CommentsController implements CommentsAPI {

    private final CommentsService commentsService;

    @Override
    @PutMapping(path = "api/comments/save/{polyclinicId}")
    public void saveCommentsById(@PathVariable final Long polyclinicId,
                                 @NotNull @Valid @RequestBody final CommentsDto commentsDto) {
        commentsService.saveComments(commentsDto, polyclinicId);
    }

    @Override
    @GetMapping(path = "api/comments/get/{polyclinicId}")
    public List<CommentsDto> getCommentsById(@PathVariable final Long polyclinicId) {
        return commentsService.getComments(polyclinicId);
    }
}
