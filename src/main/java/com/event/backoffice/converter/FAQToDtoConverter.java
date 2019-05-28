package com.event.backoffice.converter;

import com.event.backoffice.dto.FAQDto;
import com.event.backoffice.model.FAQ;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FAQToDtoConverter implements Converter<FAQ, FAQDto> {
    @Override
    public FAQDto convert(FAQ source) {
        return FAQDto.builder()
                .faqId(source.getFaqId())
                .question(source.getQuestion())
                .answer(source.getAnswer())
                .build();
    }
}
