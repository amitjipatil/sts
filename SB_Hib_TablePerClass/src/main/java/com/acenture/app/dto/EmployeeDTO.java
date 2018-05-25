package com.acenture.app.dto;

import com.acenture.app.bean.EmployeeBean;

public class EmployeeDTO {
	
	
	private int empid;
	private String name;
	private String email;
	private int salary;
	
	public EmployeeDTO() 
	{}
		
		public EmployeeDTO(int empid, String name, String email, int salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmployeeBean empdtoToEmpbean(EmployeeDTO empdto) {
		
		return null;
	}


}
