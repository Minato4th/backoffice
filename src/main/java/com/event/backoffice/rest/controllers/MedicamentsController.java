package com.event.backoffice.rest.controllers;

import com.event.backoffice.converter.MedicamentsToDtoConverter;
import com.event.backoffice.dto.MedicamentsDto;
import com.event.backoffice.model.dao.MedicamentsDao;
import com.event.backoffice.rest.MedicamentsAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class MedicamentsController implements MedicamentsAPI{

    private final MedicamentsDao medicamentsDao;

    private final MedicamentsToDtoConverter medicamentsToDtoConverter;

    @Override
    @GetMapping(path = "api/medicaments/all")
    public List<MedicamentsDto> getMedicaments() {
        return medicamentsDao.findAll().stream()
                .map(medicamentsToDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
