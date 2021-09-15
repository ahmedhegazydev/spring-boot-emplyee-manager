package com.gazzkuwait.Gazz.service;


import com.gazzkuwait.Gazz.exceptions.UserNoFoundException;
import com.gazzkuwait.Gazz.model.Employee;
import com.gazzkuwait.Gazz.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addNewEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }


    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }


    public Employee findEmployeeById(Long employeeId) {
//       return employeeRepo.findEmployeeById(employeeId);
        return employeeRepo.findEmployeeById(employeeId).orElseThrow(() -> new UserNoFoundException("User by id " + employeeId + " was not found"));
    }


    public void deleteEmployee(Long employeeId) {
        employeeRepo.deleteEmployeeById(employeeId);
    }

}
