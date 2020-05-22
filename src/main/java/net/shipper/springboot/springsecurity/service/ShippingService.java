package net.shipper.springboot.springsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.model.BillingMethod;
import net.shipper.springboot.springsecurity.model.Shipping;
import net.shipper.springboot.springsecurity.web.dto.ShippingDto;

@Service
public interface ShippingService {

	List<Shipping> findAll();
	
	List<Shipping> findAllByCustomerId(int customerId);

	Shipping findByTrackingNumber(String trackingNumber);

	Shipping saveShipping(ShippingDto shippingDto);
	
	Shipping updateShippingPrice(ShippingDto shippingDto);
	
	Double sumByBillingMethodAndCustomerId(BillingMethod billingMethodm,int customerId);
	Double sumByBillingMethodAndCustomerId(int billingMethodm,int customerId);

}
