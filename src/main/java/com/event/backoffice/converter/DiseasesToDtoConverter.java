package com.event.backoffice.converter;

import com.event.backoffice.dto.DiseasesDto;
import com.event.backoffice.model.Diseases;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DiseasesToDtoConverter implements Converter<Diseases, DiseasesDto> {

    @Override
    public DiseasesDto convert(Diseases source) {
        return DiseasesDto.builder()
                .disease(source.getDisease())
                .build();
    }
}
