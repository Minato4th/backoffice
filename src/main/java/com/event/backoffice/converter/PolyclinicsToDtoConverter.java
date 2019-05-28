package com.event.backoffice.converter;

import com.event.backoffice.dto.PolyclinicsDto;
import com.event.backoffice.model.Polyclinics;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PolyclinicsToDtoConverter implements Converter<Polyclinics, PolyclinicsDto> {

    private final PhonesToDtoConverter phonesToDtoConverter;

    private final RatingToDtoConverter ratingToDtoConverter;

    private final RemarksToDtoConverter remarksToDtoConverter;

    private final CommentsToDtoConverter commentsToDtoConverter;

    public PolyclinicsToDtoConverter(final PhonesToDtoConverter phonesToDtoConverter, RatingToDtoConverter ratingToDtoConverter, RemarksToDtoConverter remarksToDtoConverter, CommentsToDtoConverter commentsToDtoConverter) {
        this.phonesToDtoConverter = phonesToDtoConverter;
        this.ratingToDtoConverter = ratingToDtoConverter;
        this.remarksToDtoConverter = remarksToDtoConverter;
        this.commentsToDtoConverter = commentsToDtoConverter;
    }

    //TODO - rewrite get rating
    @Override
    public PolyclinicsDto convert(Polyclinics source) {
        return PolyclinicsDto.builder()
                .clinicId(source.getClinicId())
                .name(source.getName())
                .shortName(source.getShortName())
                .remark(source.getRemarks().stream()
                        .map(r -> remarksToDtoConverter.convert(r).getRemark())
                        .collect(Collectors.toList()))
                .latitude(source.getLatitude())
                .longitude(source.getLongitude())
                .address(source.getAddress())
                .rating(source.getRating().stream()
                        .map(r -> ratingToDtoConverter.convert(r).getRating())
                        .collect(Collectors.toList()).stream()
                        .mapToDouble(Double::doubleValue).average().orElse(0d))
                .phones(source.getPhones().stream()
                        .map(phonesToDtoConverter::convert)
                        .collect(Collectors.toList()))
                .comments(source.getComments().stream()
                        .map(commentsToDtoConverter::convert)
                        .collect(Collectors.toList()))
                .build();
    }
}
