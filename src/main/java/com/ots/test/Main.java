package com.ots.test;
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ots.domain.Employee;
import com.ots.domain.Timesheet;
import com.ots.service.EmployeeService;
import com.ots.service.EmployeeServiceImpl;
import com.ots.service.TimesheetService;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "file:src/main/webapp/WEB-INF/spring/timeExprServlet/servlet-context.xml" });

		EmployeeService empService = (EmployeeServiceImpl) context
				.getBean("employeeService");
		TimesheetService timesheetService = (TimesheetService) context
				.getBean("timesheetServiceImpl");

		/*List<Employee> employeeList = empService.getEmployeeList();

		for (int i = 0; i < employeeList.size(); i++) {
			LOG.info("Employee:" + employeeList.get(i));
		}
		System.out
				.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		List<Timesheet> timesheetList = timesheetService.getTimesheetList();

		for (Timesheet t : timesheetList) {
			LOG.info("Timesheet: " + t);
		}
		
		List<Timesheet> timesheetEmp1List = timesheetService.getTimesheetsByEmpId(1);
		List<Timesheet> timesheetEmp2List = timesheetService.getTimesheetsByEmpId(2);

		for(Timesheet t: timesheetEmp1List) 
			LOG.info("emp1:" + t);
		for(Timesheet t: timesheetEmp1List) 
			LOG.info("emp1:" + t);
		for(Timesheet t: timesheetEmp1List) 
			LOG.info("emp1:" + t);
		for(Timesheet t: timesheetEmp1List) 
			LOG.info("emp1:" + t);
		for(Timesheet t: timesheetEmp1List) 
			LOG.info("emp1:" + t);
		for(Timesheet t: timesheetEmp1List) 
			LOG.info("emp1:" + t);
		for(Timesheet t: timesheetEmp1List) 
			LOG.info("emp1:" + t);*/
		
		Date date = new Date(2012, 12, 12);
		System.out.println(date.getMonth());
		
		context.close();
	}
}