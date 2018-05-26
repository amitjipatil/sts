package com.acenture.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acenture.app.bean.Topic;
import com.acenture.app.dao.EmployeeDao;
import com.acenture.app.domain.Employee;
import com.acenture.app.dto.EmployeeDTO;
import com.acenture.app.dto.EmployeeDtoConvertar;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	EmployeeDTO empdto;
	
	List <Topic> topicList=new ArrayList<Topic>();
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
	
		List<Employee> elist=dao.getAllEmployees();
		return EmployeeDtoConvertar.convertEmpToEmpDto(elist);
	}


	@Override
	public EmployeeDTO getEmployee(int id) {
		Employee emp=dao.getEmployee(id);
		return EmployeeDtoConvertar.convertEmpToEmpDto(emp);
		//return null;
	}


	@Override
	public void addEmployee(EmployeeDTO empdto) {
		
		Employee emp=EmployeeDtoConvertar.convertEmpDtoToEmp(empdto);
		dao.addEmployee(emp);
	}
	

}
