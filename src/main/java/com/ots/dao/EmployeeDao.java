package com.ots.dao;

import java.util.List;

import com.ots.domain.Employee;

public interface EmployeeDao {

	public abstract List<Employee> getEmployeeList();

}