package com.event.backoffice.converter;

import com.event.backoffice.dto.CommentsDto;
import com.event.backoffice.model.Comments;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentsDtoToCommentsConverter implements Converter<CommentsDto, Comments> {

    @Override
    public Comments convert(CommentsDto source) {
        return Comments.builder()
                .comment(source.getComment())
                .creationTime(source.getCreationTime())
                .build();
    }
}
