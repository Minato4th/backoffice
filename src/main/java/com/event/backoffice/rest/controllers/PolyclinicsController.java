package com.event.backoffice.rest.controllers;

import com.event.backoffice.dto.PolyclinicsDto;
import com.event.backoffice.rest.PolyclinicsAPI;
import com.event.backoffice.service.PolyclinicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class PolyclinicsController implements PolyclinicsAPI {

    private final PolyclinicsService polyclinicsService;

    @Override
    @GetMapping(path = "api/polyclinics/all")
    public List<PolyclinicsDto> getPolyclinics() {
        return polyclinicsService.getPolyclinics();
    }

    @Override
    @GetMapping(path = "api/polyclinics/get/{polyclinicsId}")
    public PolyclinicsDto getPolyclinicsById(@PathVariable final Long polyclinicsId) {
        return polyclinicsService.getPolyclinicsDtoById(polyclinicsId);
    }

    @Override
    @GetMapping(path = "api/polyclinics/get/region/{region}")
    public List<PolyclinicsDto> getPolyclinicsByRegion(@PathVariable String region) {
        return polyclinicsService.getPolyclinicsDtoByRegion(region);
    }
}
