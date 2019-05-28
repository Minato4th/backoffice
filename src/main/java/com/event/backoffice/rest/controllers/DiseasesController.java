package com.event.backoffice.rest.controllers;

import com.event.backoffice.dto.DiseasesDto;
import com.event.backoffice.rest.DiseasesAPI;
import com.event.backoffice.service.DiseasesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class DiseasesController implements DiseasesAPI {

    private final DiseasesService diseasesService;

    @Override
    @GetMapping(path = "api/diseases/all")
    public List<DiseasesDto> getDiseases() {
        return diseasesService.getDiseases();
    }
}
