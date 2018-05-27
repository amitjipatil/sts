package com.acenture.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acenture.app.domain.Employee;

public interface EmployeeRepositary extends JpaRepository<Employee,Integer> {

}
