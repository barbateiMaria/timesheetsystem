package com.ots.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ots.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/* (non-Javadoc)
	 * @see com.ots.dao.EmployeeDao#getEmployeeList()
	 */
	@SuppressWarnings("unchecked")
	@Transactional   //you need it, otherwise no current session will be found
	public List<Employee> getEmployeeList() {
		List<Employee> list = getCurrentSession().createCriteria(Employee.class).list();
		List<Employee> employeeList = list;
		return employeeList;
	}
}
