package com.event.backoffice.rest.controllers;

import com.event.backoffice.converter.FAQToDtoConverter;
import com.event.backoffice.converter.PolyclinicsToDtoConverter;
import com.event.backoffice.converter.UserToDtoConverter;
import com.event.backoffice.dto.FAQDto;
import com.event.backoffice.dto.PolyclinicsDto;
import com.event.backoffice.model.FAQ;
import com.event.backoffice.model.Phones;
import com.event.backoffice.model.Polyclinics;
import com.event.backoffice.model.User;
import com.event.backoffice.model.dao.FAQDao;
import com.event.backoffice.model.dao.PhonesDao;
import com.event.backoffice.model.dao.PolyclinicsDao;
import com.event.backoffice.model.dao.UserDao;
import com.event.backoffice.dto.UserDto;
import com.event.backoffice.rest.MainAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
@Transactional
public class MainRestController implements MainAPI {

    private final UserDao userDao;

    private final FAQDao faqDao;

    private final PolyclinicsDao polyclinicsDao;

    private final UserToDtoConverter userToDtoConverter;

    private final PolyclinicsToDtoConverter polyclinicsToDtoConverter;

    private final PhonesDao phonesDao;

    private final FAQToDtoConverter faqToDtoConverter;

    @GetMapping(path = "getData")
    @Override
    public String getData() {
//        User user = User.builder()
//                .userName("Some")
//                .company("none")
//                .build();
//        userDao.persist(user);
//        userDao.delete(user);
        return userDao.findOne(1L).toString();
    }

    @GetMapping(path = "getUser")
    @Override
    public UserDto getUser() {
        User user = userDao.getUserById(1L);
        return userToDtoConverter.convert(user);
    }

    @GetMapping(path = "getFAQ")
    @Override
    public FAQDto getFAQ() {
        FAQ faq = faqDao.findOne(1L);
        return faqToDtoConverter.convert(faq);
    }

    @GetMapping(path = "getPolyclinic")
    @Override
    public PolyclinicsDto getPolyclinic(){
//        Polyclinics pol = Polyclinics.builder()
//                .address("some")
//                .latitude(100d)
//                .longitude(12.8d)
//                .name("Some")
//                .build();
//
//        polyclinicsDao.save(pol);
//
//        Phones phones = Phones.builder()
//                .phoneNumber("sd")
//                .polyclinics(pol)
//                .person("sds")
//                .build();
//
//        phonesDao.save(phones);

        Polyclinics polyclinics = polyclinicsDao.findOne(1l);
        return polyclinicsToDtoConverter.convert(polyclinics);
    }

    @GetMapping(path = "getPolyclinics")
    @Override
    public List<PolyclinicsDto> getPolyclinics(){
        final List<Polyclinics> polyclinics = polyclinicsDao.findAll();
        System.out.println(polyclinics.size());
        return polyclinics.stream()
                .map(polyclinicsToDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
