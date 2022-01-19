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

	public static void refactorjdbcPrepardstatement() {
		// Connection conn = null;

		String empnum, phonenum;
		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con
					.prepareStatement("SELECT EmployeeName, Phonenumber FROM employee_payrolls WHERE EmployeeName=?");
			pstmt.setString(1, "Gouthum");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				empnum = rs.getString(1);
				phonenum = rs.getString(2);
				System.out.println("EmployeeName = " + empnum + " \nPhoneNumber = " + phonenum);

			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {

		refactorjdbcPrepardstatement();
	}
}