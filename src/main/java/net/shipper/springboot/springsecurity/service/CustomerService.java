package net.shipper.springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.shipper.springboot.springsecurity.model.Customer;
import net.shipper.springboot.springsecurity.web.dto.CustomerRegistrationDto;

public interface CustomerService extends UserDetailsService {

	Customer findByEmailAddress(String emailAddress);

	Customer save(CustomerRegistrationDto registration);
	
	Customer findBycustomerID(Long customerId);
}
