package com.ots.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	@Column(name = "employee_name", nullable = false, length = 100)
	private String employeeName;

	@Column(name = "job_title", nullable = false, length = 100)
	private String jobTitle;

	@Column(name = "password", nullable = false, length = 10)
	private String password;

	@Column(name = "employee_code", nullable = false, length = 2)
	private char employeeCode;

	@Column(name = "manager_employee_id", nullable = false)
	private int managerEmployeeId;

	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Timesheet> timesheetList;

	public Employee() {
	}

	public Employee(int employeeId, String employeeName, String jobTitle,
			String password, char employeeCode, int managerEmployeeId,
			String email) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.jobTitle = jobTitle;
		this.password = password;
		this.employeeCode = employeeCode;
		this.managerEmployeeId = managerEmployeeId;
		this.email = email;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(char employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getManagerEmployeeId() {
		return managerEmployeeId;
	}

	public void setManagerEmployeeId(int managerEmployeeId) {
		this.managerEmployeeId = managerEmployeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public List<Timesheet> getTimesheetList() {
		return timesheetList;
	}

	public void setTimesheetList(List<Timesheet> timesheetList) {
		this.timesheetList = timesheetList;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", jobTitle=" + jobTitle + ", password="
				+ password + ", employeeCode=" + employeeCode
				+ ", managerEmployeeId=" + managerEmployeeId + ", email="
				+ email + ", timesheetListSize=" + timesheetList.size() + "]";
	}

}