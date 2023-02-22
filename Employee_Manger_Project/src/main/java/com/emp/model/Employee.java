package com.emp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String company;
	int salary;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Manager_employee", referencedColumnName = "managerId")
	Manager manager;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_employee", referencedColumnName = "adminId")
	Admin admin;

}
