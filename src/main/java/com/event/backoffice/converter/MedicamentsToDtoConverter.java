package com.event.backoffice.converter;

import com.event.backoffice.dto.MedicamentsDto;
import com.event.backoffice.model.Medicaments;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MedicamentsToDtoConverter implements Converter<Medicaments, MedicamentsDto> {

    @Override
    public MedicamentsDto convert(Medicaments source) {
        return MedicamentsDto.builder()
                .name(source.getName())
                .dose(source.getDose())
                .build();
    }
}
