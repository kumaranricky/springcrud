package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/health")
    public String health() {
        return "health";
    }

   
    @PostMapping("/employee")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

 
    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> listAllEmployee() {
        return employeeService.getEmployees();
    } 

  
    @GetMapping("/employee/{id}")
    @ResponseBody
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeID) {
        return employeeService.fetchEmployeeById(employeeID);
    }
    
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeID, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(employeeID, employeeDetails);
    }



    
    @DeleteMapping("/employee/{id}")
    @ResponseBody
    public Employee deleteEmployeeById(@PathVariable("id") Long employeeID) {
        return employeeService.deleteEmployeeById(employeeID);
    }

   
}
