package net.shipper.springboot.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import net.shipper.springboot.springsecurity.model.*;

public interface EmployeeRepository extends CrudRepository<Employee, String>{
    //write additional methods here if necessary
}