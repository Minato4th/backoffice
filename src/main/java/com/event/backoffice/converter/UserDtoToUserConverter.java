package com.event.backoffice.converter;

import com.event.backoffice.dto.UserDto;
import com.event.backoffice.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto source) {
        return User.builder()
                .userName(source.getUserName())
                .email(source.getEmail())
                .build();
    }
}
