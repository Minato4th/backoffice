package com.event.backoffice.converter;

import com.event.backoffice.dto.UserDto;
import com.event.backoffice.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        return UserDto.builder()
                .id(source.getId())
                .userName(source.getUserName())
                .email(source.getEmail())
//                .role(source.getRole())
//                .company(source.getCompany())
//                .refCode(source.getRefCode())
//                .enabled(source.getEnabled())
                .build();
    }
}