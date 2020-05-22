package net.shipper.springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.shipper.springboot.springsecurity.model.User;
import net.shipper.springboot.springsecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
