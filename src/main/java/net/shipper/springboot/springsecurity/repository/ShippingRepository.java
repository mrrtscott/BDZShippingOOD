package net.shipper.springboot.springsecurity.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.shipper.springboot.springsecurity.model.BillingMethod;
import net.shipper.springboot.springsecurity.model.Shipping;

@Repository
public interface ShippingRepository extends CrudRepository<Shipping,Integer> {
	List<Shipping> findAllByCustomerId(int customerId);
	Shipping findByTrackingNumber(String trackingNumber);
	
	@Query(value = "SELECT SUM(price) FROM shipping where billing_method=:billingMethod and customer_id=:customerId",nativeQuery = true)
	Double getSumByBillingMethodAndCustomerid(@Param(value = "billingMethod") BillingMethod billingMethod, @Param(value = "customerId")int customerId);
	@Query(value = "SELECT SUM(price) FROM shipping where billing_method=:billingMethod and customer_id=:customerId",nativeQuery = true)
	Double getSumByBillingMethodAndCustomerid(@Param(value = "billingMethod") int billingMethodm, @Param(value = "customerId")int customerId);
}
