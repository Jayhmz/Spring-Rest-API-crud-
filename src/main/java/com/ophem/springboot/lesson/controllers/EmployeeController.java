package com.ophem.springboot.lesson.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ophem.springboot.lesson.entity.Employee;
import com.ophem.springboot.lesson.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		/**
		 * when creating an entity object or a row in the database, the status code is
		 * created. for getting th eentity object from DB is ok
		 */
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {

		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") Integer Id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employee, Id), HttpStatus.OK);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
		
		employeeService.deleteEmployeeById(id);
		
		return new ResponseEntity<String>("successfully deleted an entity", HttpStatus.OK);
	}
}
