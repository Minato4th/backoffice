package com.event.backoffice.converter;

import com.event.backoffice.dto.RatingDto;
import com.event.backoffice.model.Ratings;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RatingDtoToRatingConverter implements Converter<RatingDto, Ratings> {

    @Override
    public Ratings convert(RatingDto source) {
        return Ratings.builder()
                .rating(source.getRating())
                .creationTime(source.getCreationTime())
                .build();
    }
}
