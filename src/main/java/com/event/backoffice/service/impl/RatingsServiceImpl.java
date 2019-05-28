package com.event.backoffice.service.impl;

import com.event.backoffice.converter.RatingDtoToRatingConverter;
import com.event.backoffice.converter.RatingToDtoConverter;
import com.event.backoffice.dto.RatingDto;
import com.event.backoffice.model.Polyclinics;
import com.event.backoffice.model.Ratings;
import com.event.backoffice.model.dao.RatingsDao;
import com.event.backoffice.service.PolyclinicsService;
import com.event.backoffice.service.RatingsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RatingsServiceImpl implements RatingsService {

    private final RatingsDao ratingsDao;

    private final RatingToDtoConverter ratingToDtoConverter;

    private final RatingDtoToRatingConverter ratingDtoToRatingConverter;

    private final PolyclinicsService polyclinicsService;

    @Override
    public List<RatingDto> getRatingsByPolyclinicId(final Long polyclinicId) {
        return ratingsDao.findAllByPolyclinics(polyclinicId).stream()
                .map(ratingToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void saveRating(RatingDto ratingDto, final Long polyclinicId) {
        final Polyclinics polyclinic = polyclinicsService.getPolyclinicsById(polyclinicId);
        Ratings ratings = ratingDtoToRatingConverter.convert(ratingDto);
        ratings.setPolyclinics(polyclinic);
        ratingsDao.save(ratings);
    }
}
