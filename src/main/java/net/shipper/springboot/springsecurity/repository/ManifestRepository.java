package net.shipper.springboot.springsecurity.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.shipper.springboot.springsecurity.model.Manifest;

@Repository
public interface ManifestRepository extends CrudRepository<Manifest,Integer> {
	Manifest findByManifestNumber(String manifestNumber);
}
