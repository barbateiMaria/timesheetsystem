package com.ots.service;

import java.util.List;

import com.ots.dao.EmployeeDao;
import com.ots.domain.Employee;

public interface EmployeeService {

	public void setEmployeeDao(EmployeeDao empDao);
	
	public List<Employee> getEmployeeList(); 
}