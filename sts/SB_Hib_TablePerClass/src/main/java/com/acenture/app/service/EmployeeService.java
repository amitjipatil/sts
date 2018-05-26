package com.acenture.app.service;

import java.util.List;

import com.acenture.app.dto.EmployeeDTO;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getEmployee(int id);

	void addEmployee(EmployeeDTO edto);

}
