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
		List<Employee_payrolljdbc> employeetest = employee.updateSalary("Terissa", 3000000);
		Assert.assertEquals(0, employeetest.size());
	}
	
}