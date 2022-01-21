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
		List<Employee_payrolljdbc> employeetest = employee.updateSalary("Terissa", 3000);
		Assert.assertEquals(2, employeetest.size());
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
	
	//UC-7 
	@Test
	public void addNewEmployeeToPayrollTest() throws SQLException
	{
		Employee_payrolljdbc employee = new Employee_payrolljdbc();
		LocalDate start_date = LocalDate.of(2020,01,05);
		int addemployee = employee.addNewEmployeeToPayroll(4,"AllenRobin","9876543221","Sales","M",12000.0f,2800.00f,1500.0f,1000.00f,5000.00f,"Bangarpet",start_date,"kolar","USA",50000);
		Assert.assertEquals(1, addemployee);
	}

	
//	@Test
//	public void addToPayrollDetailsToThePayrollTest() throws SQLException
//	{
//		Employee_payrolljdbc employee = new Employee_payrolljdbc();
//		int addemployee = employee.addToPayrollDetailsToThePayroll(5,"AllenRobin","Delhi",3500);
//		Assert.assertEquals(1, addemployee);
//	}
//	
}
