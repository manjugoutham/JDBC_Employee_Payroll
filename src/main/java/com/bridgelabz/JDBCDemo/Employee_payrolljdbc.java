package com.bridgelabz.JDBCDemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

	public static boolean usingjdbcPrepardstatement(int salary, String name) {
		// Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String query = "update employee_payrolls set " + "salary = ? " + "where EmployeeName = ? ";
			preparedStatement = con.prepareStatement(query);

			// set values
			preparedStatement.setInt(1, salary);
			preparedStatement.setString(2, name);

			// execute query
			preparedStatement.executeUpdate();

			// close connection
			preparedStatement.close();
			con.close();

			System.out.println("Record updated successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}


	public static void main(String args[]) {

		usingjdbcPrepardstatement(60000, "Gouthum");
	}
}