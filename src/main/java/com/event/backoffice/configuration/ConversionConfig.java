package com.event.backoffice.configuration;

import com.event.backoffice.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConversionConfig {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new UserToDtoConverter());
        service.addConverter(new FAQToDtoConverter());
        service.addConverter(new PolyclinicsToDtoConverter(new PhonesToDtoConverter(),
                new RatingToDtoConverter(), new RemarksToDtoConverter(), new CommentsToDtoConverter()));
        service.addConverter(new PhonesToDtoConverter());
        service.addConverter(new RatingToDtoConverter());
        service.addConverter(new MedicamentsToDtoConverter());
        service.addConverter(new RemarksToDtoConverter());
        service.addConverter(new DiseasesToDtoConverter());
        service.addConverter(new CommentsToDtoConverter());
        service.addConverter(new CommentsDtoToCommentsConverter());
        service.addConverter(new UserToDtoConverter());
        return service;
    }

}