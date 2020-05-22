package net.shipper.springboot.springsecurity.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.shipper.springboot.springsecurity.model.ShipmentStatus;

@Repository
public interface ShipmentStatusRepository extends CrudRepository<ShipmentStatus,Integer> {
	List<ShipmentStatus> findAllByShippingId(String shippingId);
}
