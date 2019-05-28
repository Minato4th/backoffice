package com.event.backoffice.converter;

import com.event.backoffice.dto.RemarksDto;
import com.event.backoffice.model.Remarks;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RemarksToDtoConverter implements Converter<Remarks, RemarksDto> {

    @Override
    public RemarksDto convert(Remarks source) {
        return RemarksDto.builder()
                .remark(source.getRemark())
                .build();
    }
}
