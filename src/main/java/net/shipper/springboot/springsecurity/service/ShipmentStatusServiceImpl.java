package net.shipper.springboot.springsecurity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.model.ShipmentStatus;
import net.shipper.springboot.springsecurity.repository.ShipmentStatusRepository;

import java.util.List;

@Service
public class ShipmentStatusServiceImpl implements ShipmentStatusService {

    @Autowired
    private ShipmentStatusRepository repository;

    public List<ShipmentStatus> findAll() {
    	return (List<ShipmentStatus>) repository.findAll();
    }
    
    public List<ShipmentStatus> findAllByShippingId(String shippingId) {
    	return (List<ShipmentStatus>) repository.findAllByShippingId(shippingId);
    }
    
    @Override
    public ShipmentStatus saveShipmentStatus(ShipmentStatus shipmentStatus) {
    	
    	return repository.save(shipmentStatus);
    }
}
