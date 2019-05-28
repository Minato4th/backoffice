package com.event.backoffice.service;

import com.event.backoffice.dto.RatingDto;

import java.util.List;

public interface RatingsService {

    List<RatingDto> getRatingsByPolyclinicId(Long PolyclinicId);

    void saveRating(RatingDto ratingDto, final Long polyclinicId);
}
