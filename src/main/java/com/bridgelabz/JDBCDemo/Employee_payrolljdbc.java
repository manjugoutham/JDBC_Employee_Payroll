package com.bridgelabz.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Employee_payrolljdbc {
	static List<Employee_payrolljdbc> list = new ArrayList<>();
	static String URL = "jdbc:mysql://localhost:3306/payroll_service?characterEncoding=utf8";
	static String USERNAME = "root";
	static String PASSWORD = "Tham12@2";

	static String EmployeeName;
	int salaay;

	public Employee_payrolljdbc() {

	}

	public Employee_payrolljdbc(String employeeName, int salaay) {
		super();
		EmployeeName = employeeName;
		this.salaay = salaay;
	}

	public static boolean findsumavgminmax() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT gender,SUM(salary),avg(salary),min(salary),max(salary),count(salary) FROM employee_payrolls GROUP BY gender;");
			
			while (rs.next())
			 System.out.println(rs.getString("gender") + " Sum==>" + rs.getInt("SUM(salary)" ) + " Avg==> "+rs.getInt("avg(salary)")  + " Min==> "+rs.getInt("min(salary)") + " Max==> "+rs.getInt("max(salary)") + " Count==> "+rs.getInt("count(salary)"));
			con.close();
		} catch (SQLException e) {
			// Handle errors for JDBC
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static void main(String args[]) {

		findsumavgminmax();
	}
}