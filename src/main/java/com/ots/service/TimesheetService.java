package com.ots.service;

import java.util.List;

import com.ots.domain.Timesheet;

public interface TimesheetService {

	public List<Timesheet> getTimesheetList();
	
	public List<Timesheet> getTimesheetsByEmpId(int employeeId);
	
}
