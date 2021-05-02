package com.employee.dao;

import org.springframework.data.repository.CrudRepository;

import com.employee.entities.Employees;

public interface EmployeeRepository extends CrudRepository<Employees, Integer> {

}
