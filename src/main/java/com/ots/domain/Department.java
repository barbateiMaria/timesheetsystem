package com.ots.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@Column(name = "department_code", nullable = false, length = 10)
	private String departmentCode;

	@Column(name = "department_name", nullable = false, length = 255)
	private String departmentName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
	private List<Timesheet> timesheetList; 
	
	public Department() {
		
	}
	
	public Department(String departmentCode, String departmentName) {
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	

	public List<Timesheet> getTimesheetList() {
		return timesheetList;
	}

	public void setTimesheetList(List<Timesheet> timesheetList) {
		this.timesheetList = timesheetList;
	}

	@Override
	public String toString() {
		return "Department [departmentCode=" + departmentCode
				+ ", departmentName=" + departmentName + ", timesheetListSize="
				+ timesheetList.size() + "]";
	}

}