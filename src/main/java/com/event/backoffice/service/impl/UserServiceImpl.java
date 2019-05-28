package com.event.backoffice.service.impl;

import com.event.backoffice.converter.UserDtoToUserConverter;
import com.event.backoffice.converter.UserToDtoConverter;
import com.event.backoffice.dto.UserDto;
import com.event.backoffice.model.dao.UserDao;
import com.event.backoffice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private UserToDtoConverter userToDtoConverter;

    private UserDtoToUserConverter userDtoToUserConverter;

    @Override
    public List<UserDto> findAllUsers() {
        return userDao.findAll().stream()
                .map(userToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(final Long Id) {
        return userToDtoConverter.convert(userDao.findOne(Id));
    }

    @Override
    public void saveInBaseIfNeed(UserDto userDto) {
        final List<UserDto> userDtos = findAllUsers();

        UserDto userDtoFinal = userDtos.stream()
                .filter(user -> user.getEmail().equals(userDto.getEmail()) && user.getUserName().equals(userDto.getUserName()))
                .findFirst()
                .orElse(null);

        if (userDtoFinal == null) {
            userDao.save(userDtoToUserConverter.convert(userDto));
        }
    }
}

