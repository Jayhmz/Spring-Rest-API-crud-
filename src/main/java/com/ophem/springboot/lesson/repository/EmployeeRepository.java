package com.ophem.springboot.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ophem.springboot.lesson.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
