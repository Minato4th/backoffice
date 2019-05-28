package com.event.backoffice.service.impl;

import com.event.backoffice.converter.CommentsDtoToCommentsConverter;
import com.event.backoffice.converter.CommentsToDtoConverter;
import com.event.backoffice.dto.CommentsDto;
import com.event.backoffice.model.Comments;
import com.event.backoffice.model.Polyclinics;
import com.event.backoffice.model.dao.CommentsDao;
import com.event.backoffice.service.CommentsService;
import com.event.backoffice.service.PolyclinicsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsDao commentsDao;

    private final CommentsDtoToCommentsConverter commentsDtoToCommentsConverter;

    private final CommentsToDtoConverter commentsToDtoConverter;

    private final PolyclinicsService polyclinicsService;

    @Override
    public void saveComments(final CommentsDto commentsDto, final Long polyclinicId) {
        final Polyclinics polyclinics = polyclinicsService.getPolyclinicsById(polyclinicId);
        Comments comments = commentsDtoToCommentsConverter.convert(commentsDto);
        comments.setPolyclinics(polyclinics);
        commentsDao.save(comments);
    }

    @Override
    public List<CommentsDto> getComments(Long polyclinicId) {
        final Polyclinics polyclinics = polyclinicsService.getPolyclinicsById(polyclinicId);
        return polyclinics.getComments().stream()
                .map(commentsToDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
