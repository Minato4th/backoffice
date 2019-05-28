package com.event.backoffice.service;

import com.event.backoffice.dto.CommentsDto;

import java.util.List;

public interface CommentsService {

    void saveComments(CommentsDto comments, Long polyclinicId);

    List<CommentsDto> getComments(Long polyclinicId);
}
