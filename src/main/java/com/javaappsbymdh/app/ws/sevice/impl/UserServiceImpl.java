package com.javaappsbymdh.app.ws.sevice.impl;

import com.javaappsbymdh.app.ws.UserRepository;
import com.javaappsbymdh.app.ws.io.entity.UserEntity;
import com.javaappsbymdh.app.ws.sevice.UserService;
import com.javaappsbymdh.app.ws.shared.Utils;
import com.javaappsbymdh.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

//if statement takes user email and checks db for the same entry. If found runtime exception is thrown. Could also use unique = true in UserEntity on email but specified runtime exception message wouldn't display.
        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists.");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(publicUserId);

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails,returnValue);

        return returnValue;
    }
}
