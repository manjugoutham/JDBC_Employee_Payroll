package com.bridgelabz.JDBCDemo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Employee_payrolljdbcTest {
	
	@Test
	public void usingjdbcPrepardstatementTest()
	{
		Employee_payrolljdbc employeetest = new Employee_payrolljdbc();
		//employee.jdbcconncetions();
		boolean result = employeetest.usingjdbcPrepardstatement(3000000,"Terissa");
		Assert.assertEquals(true, result);
	}
	
}