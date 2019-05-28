package com.event.backoffice.converter;

import com.event.backoffice.dto.RatingDto;
import com.event.backoffice.model.Ratings;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RatingToDtoConverter implements Converter<Ratings, RatingDto> {

    @Override
    public RatingDto convert(Ratings source) {
        return RatingDto.builder()
                .rating(source.getRating())
                .creationTime(source.getCreationTime())
                .build();
    }
}