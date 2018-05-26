package com.acenture.app.dao;

import java.util.List;

import com.acenture.app.domain.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();

	Employee getEmployee(int id);

	void addEmployee(Employee emp);

}
