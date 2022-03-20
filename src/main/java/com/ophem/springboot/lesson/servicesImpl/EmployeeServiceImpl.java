package com.ophem.springboot.lesson.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ophem.springboot.lesson.entity.Employee;
import com.ophem.springboot.lesson.exception.ResourceNotFoundException;
import com.ophem.springboot.lesson.repository.EmployeeRepository;
import com.ophem.springboot.lesson.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(Integer id) {
		
//		Optional<Employee> employee = employeeRepository.findById(id);
//		
//		if (employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "ID", id);
//		}
		 
		
//		using lambda code syntax
		return employeeRepository.findById(id).orElseThrow( 
				() -> new ResourceNotFoundException("Employee", "ID", id));
		
		
	}


	@Override
	public Employee updateEmployeeById(Employee employee, Integer id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow( 
									() -> new ResourceNotFoundException("Employee", "ID", id));
		
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		return existingEmployee;
		
	}


	@Override
	public void deleteEmployeeById(Integer id) {
		
		employeeRepository.findById(id).orElseThrow( () -> 
							new ResourceNotFoundException("Employee", "ID", id));
		
		employeeRepository.deleteById(id);
	}

}
