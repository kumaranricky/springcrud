package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/health")
	public String health()
	{
		return "health";
	}
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	@GetMapping("/employee")
	public List<Employee> listAllEmployee() {
		return employeeService.getEmployees();
	} 
	@GetMapping("/employee/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") Long employeeID) {
		return employeeService.fetchEmployeeById(employeeID);
	}
	@DeleteMapping("/employee/{id}")
	public Employee deleteEmployeeById(@PathVariable("id") Long employeeID) {
		return employeeService.deleteEmployeeById(employeeID);
	}

	

	


 
}
 