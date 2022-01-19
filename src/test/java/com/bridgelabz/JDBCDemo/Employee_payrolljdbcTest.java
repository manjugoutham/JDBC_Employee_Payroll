package com.bridgelabz.JDBCDemo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Employee_payrolljdbcTest {
	
	@Test
	public void updateSalaryTest()
	{
		Employee_payrolljdbc employee = new Employee_payrolljdbc();
		//employee.jdbcconncetions();
		List<Employee_payrolljdbc> employeetest = employee.updateSalary("Terissa", 3000);
		Assert.assertEquals(4, employeetest.size());
	}
	
	
	@Test
	public void usingjdbcPrepardstatementTest()
	{
		Employee_payrolljdbc employeetest = new Employee_payrolljdbc();
		//employee.jdbcconncetions();
		boolean result = employeetest.usingjdbcPrepardstatement(3000000,"Terissa");
		Assert.assertEquals(true, result);
	}
	
	
	@Test 
	public void givenDateRange_CountOfEmployee() throws SQLException {
		Employee_payrolljdbc emplpyee = new Employee_payrolljdbc();
		LocalDate startDate =LocalDate.of(2021,8,10);
		LocalDate endDate =LocalDate.of(2021,10,30);
		
		List<Employee_payrolljdbc> updatedRowsInDB = emplpyee.retrieveEmployeeallDatarange(startDate,endDate);
		Assert.assertEquals(2, updatedRowsInDB.size());  
	}

}
