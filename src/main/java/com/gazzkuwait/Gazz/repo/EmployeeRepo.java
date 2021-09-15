package com.gazzkuwait.Gazz.repo;

import com.gazzkuwait.Gazz.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo  extends JpaRepository<Employee, Long> {


//    void deleteEmployeeById(Long employeeId);


//    Employee findEmployeeById(Long employeeId);
    Optional<Employee> findEmployeeById(Long employeeId);



}
