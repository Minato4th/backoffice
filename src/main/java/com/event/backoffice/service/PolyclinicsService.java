package com.event.backoffice.service;

import com.event.backoffice.dto.PolyclinicsDto;
import com.event.backoffice.model.Polyclinics;

import java.util.List;

public interface PolyclinicsService {

    List<PolyclinicsDto> getPolyclinics();

    PolyclinicsDto getPolyclinicsDtoById(Long polyclinicsId);

    Polyclinics getPolyclinicsById(Long polyclinicsId);

    List<PolyclinicsDto> getPolyclinicsDtoByRegion(String region);
}
