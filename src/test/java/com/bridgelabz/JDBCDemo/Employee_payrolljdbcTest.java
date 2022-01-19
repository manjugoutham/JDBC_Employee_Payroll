package com.bridgelabz.JDBCDemo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Employee_payrolljdbcTest {
	
	@Test
	public void findsumavgminmaxTest()
	{
		Employee_payrolljdbc emptest = new Employee_payrolljdbc();
		boolean result = emptest.findsumavgminmax();
		Assert.assertEquals(true, result);
	}
	
}