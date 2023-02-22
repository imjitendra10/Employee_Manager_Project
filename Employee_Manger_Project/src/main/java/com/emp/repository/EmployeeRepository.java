package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	@Query("Select e from employee e where e.name like %:query%")
//	Employee EmpSearch(String query);

//	@Query("select * from employee\r\n"
//			+ " where company or employee_name or salary like '%query%';")
//	
	Employee findEmployeeByName(String name);
}
