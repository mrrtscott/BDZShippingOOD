package net.shipper.springboot.springsecurity.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.shipper.springboot.springsecurity.model.BillingMethod;
import net.shipper.springboot.springsecurity.model.CustomerAccount;
import net.shipper.springboot.springsecurity.model.Shipping;

@Repository
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount,Integer> {
	List<CustomerAccount> findAllByCustomerid(long customerId);
	CustomerAccount findByAccountID(String accountId);
	List<CustomerAccount> findByCustomerid(int customerId);
	CustomerAccount findByBillingMethodAndCustomerid(BillingMethod billingMethod, Long customerId);
}
  