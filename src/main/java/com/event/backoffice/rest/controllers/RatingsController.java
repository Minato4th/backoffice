package com.event.backoffice.rest.controllers;

import com.event.backoffice.dto.RatingDto;
import com.event.backoffice.rest.RatingsAPI;
import com.event.backoffice.service.RatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class RatingsController implements RatingsAPI {

    private final RatingsService ratingsService;

    @Override
    @PutMapping(path = "api/ratings/save/{polyclinicId}")
    public void saveRating(@PathVariable final Long polyclinicId,
                           @NotNull @Valid @RequestBody final RatingDto ratingDto) {
        ratingsService.saveRating(ratingDto, polyclinicId);
    }

}
