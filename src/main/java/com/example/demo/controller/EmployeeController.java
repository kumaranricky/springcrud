package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")  // Base path for all endpoints
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    // Health check
    @GetMapping("/health")
    public String health() {
        return "Service is up and running!";
    }

    // Create Employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> listAllEmployee() {
        return employeeService.getEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeID) {
        return employeeService.fetchEmployeeById(employeeID);
    }
    
    // Update Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeID, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(employeeID, employeeDetails);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeID) {
        employeeService.deleteEmployeeById(employeeID);
        return "Employee with ID " + employeeID + " has been deleted.";
    }
}
