package com.acenture.app.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.acenture.app.bean.EmployeeBean;
import com.acenture.app.domain.Employee;

public class EmployeeDtoConvertar {
	
	static ModelMapper modelmapper=new ModelMapper();

	public static List<EmployeeBean> convertEmpDtoToEmpBean(List<EmployeeDTO> dtolist) {
		
		List<EmployeeBean> ebeanlist=new ArrayList<EmployeeBean>();
		
		for(EmployeeDTO edto:dtolist)
		{
			EmployeeBean ebn=new EmployeeBean();
			
			modelmapper.map(edto,ebn);
			ebeanlist.add(ebn);
			
		}
		return ebeanlist;
	}

	public static List<EmployeeDTO> convertEmpToEmpDto(List<Employee> elist) {
		
		List<EmployeeDTO> dtolist=new ArrayList<EmployeeDTO>();
		for(Employee employee:elist)
		{
			EmployeeDTO edto= new EmployeeDTO();			
		modelmapper.map(employee, edto);
		dtolist.add(edto);
		}
		return dtolist;
	}

	public static EmployeeDTO convertEmpToEmpDto(Employee emp) {
		
		EmployeeDTO edtoo= new EmployeeDTO();			
		modelmapper.map(emp, edtoo);
		return edtoo;
	}

	public static EmployeeBean convertEmpDtoToEmpBean(EmployeeDTO edto) {
		
		EmployeeBean ebn=new EmployeeBean();
		modelmapper.map(edto,ebn);
		return ebn;
	}

	public static EmployeeDTO convertEmpBeanToEmpDto(EmployeeBean employeebean) {
		EmployeeDTO edtoo= new EmployeeDTO();
		modelmapper.map(employeebean,edtoo);
		return edtoo;
	}

	public static Employee convertEmpDtoToEmp(EmployeeDTO empdto) {
		Employee employee=new Employee();
		modelmapper.map(empdto,employee);
		return employee;
	}
	

}
