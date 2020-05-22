package net.shipper.springboot.springsecurity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.config.Common;
import net.shipper.springboot.springsecurity.model.Customer;
import net.shipper.springboot.springsecurity.model.Role;
import net.shipper.springboot.springsecurity.repository.CustomerRepository;
import net.shipper.springboot.springsecurity.web.dto.CustomerRegistrationDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    private String birthstring;
    private Date birthdate;

    public Customer findByEmailAddress(String emailAddress){
        return customerRepository.findByEmailAddress(emailAddress);
    }

    public Customer save(CustomerRegistrationDto registration){
    	Customer customer = new Customer();
    	customer.setFirstName(registration.getFirstName());
    	customer.setLastName(registration.getLastName());
        customer.setEmailAddress(registration.getEmailAddress());
        customer.setPassword(passwordEncoder.encode(registration.getPassword()));
        customer.setSex(Integer.parseInt(registration.getSex()));
        
        birthstring = registration.getBirth();
        try {
			birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthstring);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        customer.setDateOfBirth(birthdate);
        customer.setRoles(Arrays.asList(new Role("ROLE_CUSTOMER")));
        
        return customerRepository.save(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
    	Customer customer = customerRepository.findByEmailAddress(emailAddress);
        if (customer == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        } 
        return new org.springframework.security.core.userdetails.User(customer.getEmailAddress(),
        		customer.getPassword(),
                mapRolesToAuthorities(customer.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

	@Override
	public Customer findBycustomerID(Long customerId) {
		return customerRepository.findByCustomerID(customerId);
	}
}
