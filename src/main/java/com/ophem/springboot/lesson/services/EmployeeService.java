package com.ophem.springboot.lesson.services;

import java.util.List;

import com.ophem.springboot.lesson.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(Integer id);
	
	Employee updateEmployeeById(Employee employee, Integer id);
	
	void deleteEmployeeById(Integer id);

}
