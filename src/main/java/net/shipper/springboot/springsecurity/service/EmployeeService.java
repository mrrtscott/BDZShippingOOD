package net.shipper.springboot.springsecurity.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shipper.springboot.springsecurity.model.Employee;
import net.shipper.springboot.springsecurity.repository.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    /*

    public Employee getEmployee(String employeeID) {
        return employeeRepository.findOne(employeeID);
    }

    */

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String employeeID) {
        employeeRepository.deleteById(employeeID);
    }
}