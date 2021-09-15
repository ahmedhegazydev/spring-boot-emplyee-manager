package com.gazzkuwait.Gazz.controller;


import com.gazzkuwait.Gazz.model.Employee;
import com.gazzkuwait.Gazz.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeResource {


    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    @GetMapping /// or
//    @GetMapping("/all")
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employeeList = employeeService.getAllEmployees();
//        return new ResponseEntity<>(employeeList, HttpStatus.OK);
//    }
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Employee> getAllEmployees() {
        // This returns a JSON or XML with the users
        return employeeService.getAllEmployees();
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.addNewEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @PostMapping(path = "/addReqParam") // Map ONLY POST Requests
    public @ResponseBody
    String addNewEmployee(
            @RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Employee n = new Employee();
        n.setName(name);
        n.setEmail(email);
        employeeService.addNewEmployee(n);
        return "Saved";
    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }


//    @DeleteMapping("/deleteEmp/{id}")
    @DeleteMapping(value = "/delete/{id}")
//    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
