package com.event.backoffice.service.impl;

import com.event.backoffice.converter.PolyclinicsToDtoConverter;
import com.event.backoffice.dto.PolyclinicsDto;
import com.event.backoffice.model.Polyclinics;
import com.event.backoffice.model.dao.PolyclinicsDao;
import com.event.backoffice.service.PolyclinicsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PolyclinicsServiceImpl implements PolyclinicsService {

    private final PolyclinicsDao polyclinicsDao;

    private final PolyclinicsToDtoConverter polyclinicsToDtoConverter;

    @Override
    public List<PolyclinicsDto> getPolyclinics() {
        return polyclinicsDao.findAll().stream()
                .map(polyclinicsToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PolyclinicsDto getPolyclinicsDtoById(final Long polyclinicsId) {
        final Polyclinics polyclinics = polyclinicsDao.findPolyclinicsById(polyclinicsId);
        return polyclinicsToDtoConverter.convert(polyclinics);
    }

    @Override
    public Polyclinics getPolyclinicsById(final Long polyclinicsId) {
        return polyclinicsDao.findPolyclinicsById(polyclinicsId);
    }

    @Override
    public List<PolyclinicsDto> getPolyclinicsDtoByRegion(final String region) {
        return polyclinicsDao.findPolyclinicsByRegion(region).stream()
                .map(polyclinicsToDtoConverter::convert)
                .collect(Collectors.toList());
    }

}
