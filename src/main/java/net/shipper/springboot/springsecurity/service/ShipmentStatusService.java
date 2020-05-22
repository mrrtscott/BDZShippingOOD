package net.shipper.springboot.springsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.model.ShipmentStatus;

@Service
public interface ShipmentStatusService {
	List<ShipmentStatus> findAll();
	List<ShipmentStatus> findAllByShippingId(String shippingId);
	ShipmentStatus saveShipmentStatus(ShipmentStatus shipmentStatus);
}
