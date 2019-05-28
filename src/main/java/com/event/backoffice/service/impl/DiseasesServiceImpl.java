package com.event.backoffice.service.impl;

import com.event.backoffice.converter.DiseasesToDtoConverter;
import com.event.backoffice.dto.DiseasesDto;
import com.event.backoffice.model.dao.DiseasesDao;
import com.event.backoffice.service.DiseasesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DiseasesServiceImpl implements DiseasesService {

    private final DiseasesDao diseasesDao;

    private final DiseasesToDtoConverter diseasesToDtoConverter;

    @Override
    public List<DiseasesDto> getDiseases() {
        return diseasesDao.findAll().stream()
                .map(diseasesToDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
