package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee fetchEmployeeById(Long employeeID);
	
	Employee updateEmployee(Long empId, Employee employeeDetails);

	Employee deleteEmployeeById(Long employeeID);


}
