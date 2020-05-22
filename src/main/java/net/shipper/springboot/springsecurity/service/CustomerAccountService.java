package net.shipper.springboot.springsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.model.CustomerAccount;
import net.shipper.springboot.springsecurity.model.Shipping;
import net.shipper.springboot.springsecurity.web.dto.CustomerAccountDto;
import net.shipper.springboot.springsecurity.web.dto.ShippingDto;

@Service
public interface CustomerAccountService {

	List<CustomerAccount> findAll();
	
	List<CustomerAccount> findAllByCustomerid(long customerId); 

	CustomerAccount findByAccountID(String accountId);
	
	CustomerAccount saveCustomerAccount(CustomerAccountDto customerAccountDto);
	
	
}
