package com.emp.service;

import com.emp.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	Employee update(Employee employee, Integer id) throws Exception;

	Employee delete(Employee employee, Integer id) throws Exception;
	Employee search(String name);

}
