package com.ots.dao;

import java.util.List;

import com.ots.domain.Timesheet;

public interface TimesheetDao {

	public List<Timesheet> getTimesheetList();
	
	public List<Timesheet> getTimesheetsByEmpId(int employeeId);
	
	public Timesheet addTimesheet(Timesheet timesheet);
	
}
