package com.javaappsbymdh.app.ws.sevice;

import com.javaappsbymdh.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
}
