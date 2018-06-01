package com.acenture.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	SessionFactory sessionFactory;
	
	@Autowired
	EmployeeRepositary employeeRepositary;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		
		
		//*** By using EntityManager
		// String hql = "FROM Employee as empl ORDER BY empl.empid";
		//return (List<Employee>) entityManager.createQuery(hql).getResultList();
		
		//*** By using JpaRepositary
		//return employeeRepositary.findAll();
		
		//*** By using Hibernate SessionFactory
		Session session=null;
		try
		{
			session=sessionFactory.openSession();
			Query q1=session.createQuery("from Employee eb");
			List <Employee>list=q1.list();
			  session.close();
			return list;
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		System.out.println("get employee");
		
		//*** By using EntityManager
		//return entityManager.find(Employee.class,id);
		
		//*** By using JpaRepositary
		//return employeeRepositary.findOne(id);
		
		//*** By using Hibernate SessionFactory
		Session session=null;
		try
		{
			session=sessionFactory.openSession();
			Employee ee=session.get(Employee.class,id);
			session.close();
			return ee;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		//*** By using EntityManager
		//entityManager.getTransaction().begin();
		//System.out.println("Saving Employee to Database"+employee.getName()+"=="+employee.getSalary());
		//entityManager.persist(employee);
		//entityManager.getTransaction().commit();
		
		//*** By using JpaRepositary
		//employeeRepositary.save(employee);
		
		//*** By using Hibernate SessionFactory
		Session session=null;
		try
		{
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			 session.save(employee);
			 tx.commit();
			 session.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}

}
