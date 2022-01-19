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

	public static void jdbcconncetions() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<Employee_payrolljdbc> updateSalary(String name, int salary) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// System.out.println("connection success");
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate("UPDATE employee_payrolls SET  salary = " + salary + "  WHERE EmployeeName ='" + name + "';");

			jdbcconncetions();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// listDrivers()
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String args[]) {

		updateSalary("Terissa", 3000000);
		jdbcconncetions();

	}
}