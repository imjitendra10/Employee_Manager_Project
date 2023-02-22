package com.emp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee, Integer id) throws Exception {
		Optional<Employee> existedEmp = employeeRepository.findById(id);
		if (existedEmp.isPresent()) {
			return employeeRepository.save(employee);
		}
		throw new Exception("Employee not found");
	}

	@Override
	public Employee delete(Employee employee, Integer id) throws Exception {
		Optional<Employee> existedEmp = employeeRepository.findById(id);
		if (existedEmp.isPresent()) {
			employeeRepository.delete(employee);

		}
		return null;

	}

	@Override
	public Employee search(String name) {
		return employeeRepository.findEmployeeByName(name);
	}

}
