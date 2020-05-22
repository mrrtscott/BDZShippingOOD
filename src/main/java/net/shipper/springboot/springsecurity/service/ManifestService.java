package net.shipper.springboot.springsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.model.Manifest;

@Service
public interface ManifestService {

	List<Manifest> findAll();
	Manifest findByManifestNumber(String manifestNumber);

	Manifest saveManifest(Manifest manifest);
}
