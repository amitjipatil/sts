package com.acenture.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acenture.app.domain.Employee;
import com.acenture.app.repositary.EmployeeRepositary;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	//@PersistenceContext(unitName="somepu",type=PersistanceContextType.EXTENDED);	
	//@PersistenceContext
	//private EntityManager entityManager;
	
	@Autowired
	EmployeeRepositary employeeRepositary;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		
		String hql = "FROM Employee as empl ORDER BY empl.empid";
		//return (List<Employee>) entityManager.createQuery(hql).getResultList();
		//return null;
		return employeeRepositary.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		System.out.println("get employee");
		
		//return entityManager.find(Employee.class,id);
		return employeeRepositary.findOne(id);
	
	}

	//@Transactional
	@Override
	public void addEmployee(Employee employee) {
		//entityManager.getTransaction().begin();
		//System.out.println("Saving Employee to Database"+employee.getName()+"=="+employee.getSalary());
		//entityManager.persist(employee);
		//entityManager.getTransaction().commit();
		employeeRepositary.save(employee);
		
	}

}
