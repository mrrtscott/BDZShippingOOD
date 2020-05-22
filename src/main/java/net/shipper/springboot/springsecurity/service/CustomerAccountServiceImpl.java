package net.shipper.springboot.springsecurity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.config.Common;
import net.shipper.springboot.springsecurity.model.CustomerAccount;
import net.shipper.springboot.springsecurity.repository.CustomerAccountRepository;
import net.shipper.springboot.springsecurity.web.dto.CustomerAccountDto;

import java.util.List;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

      
    public List<CustomerAccount> findAll() {
    	return (List<CustomerAccount>) customerAccountRepository.findAll();
    }
    
    public List<CustomerAccount> findAllByCustomerid(long customerId) {
        return (List<CustomerAccount>) customerAccountRepository.findAllByCustomerid(customerId);
    }

    @Override
    public CustomerAccount findByAccountID(String accountId) {
        return customerAccountRepository.findByAccountID(accountId);
    }

    @Override
    public CustomerAccount saveCustomerAccount(CustomerAccountDto Dto) {
    	CustomerAccount customerAccount = new CustomerAccount(); 
    	customerAccount.setCustomerid((long)Common.customerId);
    	customerAccount.setAccountBalance(Dto.getAccountBalance());  
    	customerAccount.setBillingMethod(Dto.getBillingMethod());
    	customerAccount.setAccountID(Dto.getAccountID()); 
    	return customerAccountRepository.save(customerAccount);
    }
}
