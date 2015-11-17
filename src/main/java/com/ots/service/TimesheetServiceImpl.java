package com.ots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ots.dao.TimesheetDao;
import com.ots.domain.Timesheet;

@Service
public class TimesheetServiceImpl implements TimesheetService {

	@Autowired
	private TimesheetDao timesheetDao;
	
	public TimesheetDao getTimesheetDao() {
		return timesheetDao;
	}
	
	public void setTimesheetDao(TimesheetDao timesheetDao) {
		this.timesheetDao = timesheetDao;
	}
	
	public List<Timesheet> getTimesheetList() {
		return timesheetDao.getTimesheetList();
	}

	public List<Timesheet> getTimesheetsByEmpId(int employeeId) {
		return timesheetDao.getTimesheetsByEmpId(employeeId);
	}

}