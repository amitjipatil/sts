package com.acenture.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acenture.app.domain.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		
		String hql = "FROM Employee as empl ORDER BY empl.empid";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
		//return null;
	}

	@Override
	public Employee getEmployee(int id) {
		
		return entityManager.find(Employee.class,id);
	
	}

	//@Transactional
	@Override
	public void addEmployee(Employee employee) {
		entityManager.getTransaction().begin();
		System.out.println("Saving Employee to Database"+employee.getName()+"=="+employee.getSalary());
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
	}

}
