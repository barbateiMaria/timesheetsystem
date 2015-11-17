package com.ots.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "statuses")
public class Status {

	@Id
	@Column(name = "status_code", nullable = false, length = 10)
	private String statusCode;
	
	@Column(name = "status_name", nullable = false, length = 25)
	private String statusName;

	@OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
	private List<Timesheet> timesheetList;
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "Status [statusCode=" + statusCode + ", statusName="
				+ statusName + "]";
	}
	
}
