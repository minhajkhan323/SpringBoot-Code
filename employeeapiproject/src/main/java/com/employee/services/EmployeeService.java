package com.employee.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.dao.EmployeeRepository;
import com.employee.entities.Employees;

@Component
public class EmployeeService {
	

	@Autowired
	private EmployeeRepository employeeRepository ;
	
	
	//Get all the employees details from db
	//GET method
	public List<Employees> getAllEmployees()
	{
		List<Employees> list=(List<Employees>)this.employeeRepository.findAll();
		if (list.size()<=0) {
			
		}
		return list;
		
	}
	
	//Get Employee details by id
	//GET method
	public Optional<Employees> getEmployeeById(int id)
	{
		Optional<Employees> employees = null;
		employees=this.employeeRepository.findById(id);
		return employees;
		
	}
	
	//Add new employee
	//POST Method
	public Employees addEmployee(Employees employees)
	{
		return this.employeeRepository.save(employees);
	}
	
	
	//Update Employee Details
	//PUT method
	public Employees updateEmployee(Employees employees,int id)
	{
		 return employeeRepository.save(employees);
	}
	
	//Delete Employee By Id
	//DELETE method
	public void deleteEmployee(int id)
	{
		this.employeeRepository.deleteById(id);
	}
	
	
}
