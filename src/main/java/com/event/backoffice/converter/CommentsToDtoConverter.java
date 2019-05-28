package com.event.backoffice.converter;

import com.event.backoffice.dto.CommentsDto;
import com.event.backoffice.model.Comments;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentsToDtoConverter implements Converter<Comments, CommentsDto> {

    @Override
    public CommentsDto convert(Comments source) {
        return CommentsDto.builder()
                .comment(source.getComment())
                .creationTime(source.getCreationTime())
                .build();
    }
}
