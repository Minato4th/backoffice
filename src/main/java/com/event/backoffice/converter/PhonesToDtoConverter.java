package com.event.backoffice.converter;

import com.event.backoffice.dto.PhonesDto;
import com.event.backoffice.model.Phones;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PhonesToDtoConverter implements Converter<Phones, PhonesDto> {

    @Override
    public PhonesDto convert(Phones source) {
        return PhonesDto.builder()
                .person(source.getPerson())
                .phoneNumber(source.getPhoneNumber())
                .build();
    }
}
