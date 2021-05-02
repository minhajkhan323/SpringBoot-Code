package com.employee.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employees;
import com.employee.services.EmployeeService;

@RestController
public class EmployeeControllers {
	
	
	@Autowired
	public EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employees>> getEmployees()
	{
		List<Employees> list=this.employeeService.getAllEmployees();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employees> getEmployeeById(@PathVariable("id")int id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employees> addEmployees(@RequestBody Employees employees)
	{
		Employees emp = null;
		try {
			emp=this.employeeService.addEmployee(employees);
			return ResponseEntity.status(HttpStatus.CREATED).body(emp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/employees/{id}")
	public Employees updateEmployee(@RequestBody Employees employees,@PathVariable("id")int id)
	{
		
		return this.employeeService.updateEmployee(employees, id);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable("id") int id)
	{
		this.employeeService.deleteEmployee(id);
	}
	
	
	
	

}
