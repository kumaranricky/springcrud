package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
@Service
public class EmployeeServiceimp1 implements EmployeeService{
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepo.save(employee);
	}
	@Override
	public List<Employee> getEmployees()
	{
		return employeeRepo.findAll();
	
	}
	@Override
	public Employee fetchEmployeeById(Long empId)
	{
		return employeeRepo.findById(empId).get();	}
	@Override
	public Employee deleteEmployeeById(Long empId)
	{
		 Employee emp=this.fetchEmployeeById(empId);
		 employeeRepo.delete(emp);
		 return emp ;}
	
}
 