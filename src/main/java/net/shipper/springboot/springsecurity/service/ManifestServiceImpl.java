package net.shipper.springboot.springsecurity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.model.Manifest;
import net.shipper.springboot.springsecurity.repository.ManifestRepository;

import java.util.List;

@Service
public class ManifestServiceImpl implements ManifestService {

    @Autowired
    private ManifestRepository repository;

    
    public List<Manifest> findAll() {
    	return (List<Manifest>) repository.findAll();
    }

    @Override
    public Manifest findByManifestNumber(String manifestNumber) {
        return repository.findByManifestNumber(manifestNumber);
    }

    @Override
    public Manifest saveManifest(Manifest manifest) {
    	
    	return repository.save(manifest);
    }
}
