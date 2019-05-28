package com.event.backoffice.rest.controllers;

import com.event.backoffice.converter.FAQToDtoConverter;
import com.event.backoffice.dto.FAQDto;
import com.event.backoffice.model.dao.FAQDao;
import com.event.backoffice.rest.FaqAPI;
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
public class FaqController implements FaqAPI{

    private final FAQDao faqDao;

    private final FAQToDtoConverter faqToDtoConverter;

    @Override
    @GetMapping(path = "api/faq/all")
    public List<FAQDto> getFAQ() {
        return faqDao.findAll().stream()
                .map(faqToDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
