package com.event.backoffice.service.impl;

import com.event.backoffice.converter.FAQToDtoConverter;
import com.event.backoffice.dto.FAQDto;
import com.event.backoffice.model.dao.FAQDao;
import com.event.backoffice.service.FaqService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class FaqServiceImpl implements FaqService{

    private final FAQDao faqDao;

    private final FAQToDtoConverter faqToDtoConverter;

    @Override
    public List<FAQDto> getFAQ() {
        return faqDao.findAll().stream()
                .map(faqToDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
