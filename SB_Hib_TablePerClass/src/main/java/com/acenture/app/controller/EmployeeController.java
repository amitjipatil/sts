package com.acenture.app.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acenture.app.bean.EmployeeBean;
import com.acenture.app.dto.EmployeeDTO;
import com.acenture.app.dto.EmployeeDtoConvertar;
import com.acenture.app.service.EmployeeService;

//@RequestMapping("/peoples")

@RestController
public class EmployeeController {

	
	
	@Autowired
	EmployeeService employeeservice;
	
	
	@GetMapping("/employees")
	public List<EmployeeBean> getAllTopics()
	{
		
		List<EmployeeDTO> dtolist=employeeservice.getAllEmployees();
		return EmployeeDtoConvertar.convertEmpDtoToEmpBean(dtolist);
	}
	
	@RequestMapping("/employees/{id}")
	public EmployeeBean getEmployee(@PathVariable int empid)
	{
		EmployeeDTO edto=employeeservice.getEmployee(empid);
		return EmployeeDtoConvertar.convertEmpDtoToEmpBean(edto);
	}
	
	@RequestMapping(value="/employees",method=RequestMethod.POST)
	public void addTopic(@RequestBody EmployeeBean employeebean)
	{
		EmployeeDTO edto=EmployeeDtoConvertar.convertEmpBeanToEmpDto(employeebean);
		employeeservice.addEmployee(edto);
	}
	
}
