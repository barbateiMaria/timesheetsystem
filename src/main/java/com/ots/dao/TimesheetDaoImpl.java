package com.ots.dao;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ots.domain.Timesheet;

@Repository
public class TimesheetDaoImpl implements TimesheetDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOG = Logger.getLogger(TimesheetDaoImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Timesheet> getTimesheetList() {
		List<Timesheet> timesheetList = getCurrentSession().createCriteria(
				Timesheet.class).list();
		if (timesheetList != null) {
			LOG.info("Timesheet List has been successfully retrieved");
		} else {
			LOG.info("Timesheet List is empty");
		}
		return timesheetList;
	}

	/**
	 * Returns timesheets of an specific employee
	 * 
	 * @param employeeId
	 * @return timesheetEmpList
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Cacheable("timesheetsEmpId")
	public List<Timesheet> getTimesheetsByEmpId(int employeeId) {
		Query query = getCurrentSession().createQuery(
				"from Timesheet where employee.employeeId = :employeeId");
		query.setParameter("employeeId", employeeId);
		List<Timesheet> timesheetEmpList = query.list();
		if (timesheetEmpList != null) {
			LOG.info("Timesheet List of employee with employeeId: "
					+ employeeId + "has been successfully retrieved.");
		} else {
			LOG.info("Employee with employeeId: " + employeeId
					+ "has no timesheet list.");
		}
		return timesheetEmpList;
	}

	@Cacheable("timesheetEmpIdPE")
	public boolean findTimesheetByPeriodEndingPerEmployee(Date periodEnding,
			int employeeId) {
		List<Timesheet> timesheetEmpList = getTimesheetsByEmpId(employeeId);
		for (Timesheet t : timesheetEmpList) {
			if (t.getPeriodEnding().equals(periodEnding))
				LOG.info("Timesheet with period ending: " + periodEnding
						+ "aready exists.");
			return true;
		}
		return false;
	}

	/**
	 * Adds a timesheet in the database
	 * 
	 * @param timesheet
	 * @return timesheet
	 */
	@Transactional
	public Timesheet addTimesheet(Timesheet timesheet) {
		if (!findTimesheetByPeriodEndingPerEmployee(
				timesheet.getPeriodEnding(), timesheet.getEmployee()
						.getEmployeeId())) {
			getCurrentSession().persist(timesheet);
			LOG.info("Timesheet successfully added to database.");
			return timesheet;
		} else {
			LOG.info("Timesheet already exists.");
			return null;
		}
	}

	/**
	 * 
	 * Updates a timesheet in the database
	 * 
	 * @param Timesheet
	 *            t
	 * @return true - if the update was successful false - otherwise
	 */
	@Transactional
	public boolean updateTimesheet(Timesheet t) {
		boolean updated = false;
		if (getTimesheetsByEmpId(t.getEmployee().getEmployeeId()) != null) {
			getCurrentSession().update(t);
			LOG.info("Timesheet with period ending" + t.getPeriodEnding()
					+ " has been successfully updated");
			updated = true;
		}
		return updated;
	}

	public List<Timesheet> getTimesheetsFromCurrentMonth(int employeeId) {
		return null;
	}

}