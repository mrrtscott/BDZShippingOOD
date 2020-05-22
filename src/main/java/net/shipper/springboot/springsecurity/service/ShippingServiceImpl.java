package net.shipper.springboot.springsecurity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.config.Common;
import net.shipper.springboot.springsecurity.model.BillingMethod;
import net.shipper.springboot.springsecurity.model.CustomerAccount;
import net.shipper.springboot.springsecurity.model.Shipping;
import net.shipper.springboot.springsecurity.repository.CustomerAccountRepository;
import net.shipper.springboot.springsecurity.repository.ShippingRepository;
import net.shipper.springboot.springsecurity.web.dto.ShippingDto;

import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;
    
    @Autowired
    CustomerAccountRepository customerAccountRepository;

    
    public List<Shipping> findAll() {
    	return (List<Shipping>) shippingRepository.findAll();
    }
    public List<Shipping> findAllByCustomerId(int customerId) {
        return (List<Shipping>) shippingRepository.findAllByCustomerId(customerId);
    }

    @Override
    public Shipping findByTrackingNumber(String trackingNumber) {
        return shippingRepository.findByTrackingNumber(trackingNumber);
    }

    @Override
    public Shipping saveShipping(ShippingDto shippingDto) {
    	Shipping shipping = new Shipping();
    	shipping.setTrackingNumber(shippingDto.getTrackingNumber());
    	shipping.setCustomerId((int)Common.customerId);
    	shipping.setDescription(shippingDto.getDescription());
    	shipping.setDimensions(shippingDto.getDimensions());
    	shipping.setOrigin(shippingDto.getOrigin());
    	shipping.setDestination(shippingDto.getDestination());
    	shipping.setBillingMethod(shippingDto.getBillingMethod());
    	// shipping.setShipmentStatus(shippingDto.getShipmentStatusId());
    	return shippingRepository.save(shipping);
    }
	@Override
	public Shipping updateShippingPrice(ShippingDto shippingDto) {
		Double newPrice=shippingDto.getPrice();
		String trackingId=shippingDto.getTrackingNumber();
		Shipping shipping=shippingRepository.findByTrackingNumber(trackingId);
		shipping.setPrice(newPrice);
		return shippingRepository.save(shipping);
	}
	@Override
	public Double sumByBillingMethodAndCustomerId(BillingMethod billingMethod, int customerId) {
		return shippingRepository.getSumByBillingMethodAndCustomerid(billingMethod,customerId);
	}
	@Override
	public Double sumByBillingMethodAndCustomerId(int billingMethod, int customerId) {
		return shippingRepository.getSumByBillingMethodAndCustomerid(billingMethod,customerId);
		}
}
