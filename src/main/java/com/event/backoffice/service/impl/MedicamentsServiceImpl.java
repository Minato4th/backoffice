package com.event.backoffice.service.impl;

import com.event.backoffice.converter.MedicamentsToDtoConverter;
import com.event.backoffice.dto.MedicamentsDto;
import com.event.backoffice.model.dao.MedicamentsDao;
import com.event.backoffice.service.MedicamentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class MedicamentsServiceImpl implements MedicamentsService {

    private final MedicamentsDao medicamentsDao;

    private final MedicamentsToDtoConverter medicamentsToDtoConverter;

    @Override
    public List<MedicamentsDto> getMedicaments() {
        return medicamentsDao.findAll().stream()
                .map(medicamentsToDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
