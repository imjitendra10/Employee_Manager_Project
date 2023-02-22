package com.emp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/add")
	public Employee add(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@DeleteMapping("/id/{id}")
	public Employee delete(@RequestBody Employee employee, Integer id) throws Exception {
		return employeeService.delete(employee, id);
	}

	@PutMapping("update/{id}")
	public Employee update(@RequestBody Employee employee, Integer id) throws Exception {
		return employeeService.update(employee, id);
	}

	@GetMapping("/get/{id}")
	public Optional<Employee> remove(@RequestBody Employee employee, @PathVariable int id) {
		return employeeRepository.findById(id);
	}

	@GetMapping("/search/{name}")
	public Employee search(@PathVariable String name, @RequestBody Employee employee) {
		employeeService.search(name);
		return employee;
	}

//	@GetMapping("/{search}")
//	public Employee allSearch( @RequestBody Employee employee, @PathVariable String search) {
//		return employeeRepository.EmpSearch(search);
//
//	}
}
