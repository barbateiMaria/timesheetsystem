package com.ots.domain;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timesheets")
public class Timesheet {
	
	@Id
	@Column(name = "timesheet_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timesheetId;
	
	@Column(name = "hours_monday", nullable = false)
	private float hoursMon;
	
	@Column(name = "hours_tuesday", nullable = false)
	private float hoursTue;
	
	@Column(name = "hours_wednesday", nullable = false)
	private float hoursWed;
	
	@Column(name = "hours_thursday", nullable = false)
	private float hoursThur;
	
	@Column(name = "hours_friday", nullable = false)
	private float hoursFri;
	
	@ManyToOne
	@JoinColumn(name = "department_code", nullable = false)
	private Department department;
	
	@Column(name = "period_ending")
	private Date periodEnding;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "status", nullable = false)
	private Status status;
	
	public Timesheet() {
	}	

	public int getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}

	public float getHoursMon() {
		return hoursMon;
	}

	public void setHoursMon(float hoursMon) {
		this.hoursMon = hoursMon;
	}

	public float getHoursTue() {
		return hoursTue;
	}

	public void setHoursTue(float hoursTue) {
		this.hoursTue = hoursTue;
	}

	public float getHoursWed() {
		return hoursWed;
	}

	public void setHoursWed(float hoursWed) {
		this.hoursWed = hoursWed;
	}

	public float getHoursThur() {
		return hoursThur;
	}

	public void setHoursThur(float hoursThur) {
		this.hoursThur = hoursThur;
	}

	public float getHoursFri() {
		return hoursFri;
	}

	public void setHoursFri(float hoursFri) {
		this.hoursFri = hoursFri;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getPeriodEnding() {
		return periodEnding;
	}

	public void setPeriodEnding(Date periodEnding) {
		this.periodEnding = periodEnding;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", hoursMon="
				+ hoursMon + ", hoursTue=" + hoursTue + ", hoursWed="
				+ hoursWed + ", hoursThur=" + hoursThur + ", hoursFri="
				+ hoursFri + ", department=" + department + ", periodEnding="
				+ periodEnding + ", employee=" + employee + "]";
	}
	
}
