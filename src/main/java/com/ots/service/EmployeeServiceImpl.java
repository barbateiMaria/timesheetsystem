package com.ots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ots.dao.EmployeeDao;
import com.ots.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	public EmployeeDao getEmployeeDao() {
		return empDao;
	}
	
	public void setEmployeeDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	
	public List<Employee> getEmployeeList() {
		return empDao.getEmployeeList();
	}
	
}
