package net.shipper.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.shipper.springboot.springsecurity.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    //write additional methods here if necessary
	Customer findByEmailAddress(String emailAddress);

	Customer findByCustomerID(Long customerId);
	
}