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

	public static void retrieveEmployeePayroll() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee_payrolls");
			while (rs.next())
				list.add(new Employee_payrolljdbc(rs.getString("EmployeeName"), rs.getInt("salary")));
			// System.out.println(rs.getString("EmployeeName") + " " + rs.getInt("salary"));
			System.out.println(list.size());
			con.close();
		} catch (SQLException e) {
			// Handle errors for JDBC
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
			int rs = stmt.executeUpdate(
					"UPDATE employee_payrolls SET  salary = " + salary + "  WHERE EmployeeName ='" + name + "';");

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

	public static boolean usingjdbcPrepardstatement(int salary, String name) {
		// Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String query = "update employee_payrolls set " + "salary = ? " + "where EmployeeName = ? ";
			// conn = JDBCUtil.getConnection();
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

	public static List<Employee_payrolljdbc> retrieveEmployeeallDatarange(LocalDate start, LocalDate end) {

		String query = String.format("select * FROM employee_payrolls where start_date BETWEEN '%s' AND '%s';",
				Date.valueOf(start), Date.valueOf(end));
		List<Employee_payrolljdbc> employeePayRollJDBCs = new ArrayList<>();
		try {

			System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				list.add(new Employee_payrolljdbc(rs.getString("EmployeeName"), rs.getInt("salary")));
			System.out.println(list.size());
			employeePayRollJDBCs.forEach(System.out::println);
			stmt.close();
			rs.close();
			con.close();

			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public static void findsumavgminmax() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT gender,SUM(salary),avg(salary),min(salary),max(salary),count(salary) FROM employee_payrolls GROUP BY gender;");

			while (rs.next())
				System.out.println(rs.getString("gender") + " Sum==>" + rs.getInt("SUM(salary)") + " Avg==> "
						+ rs.getInt("avg(salary)") + " Min==> " + rs.getInt("min(salary)") + " Max==> "
						+ rs.getInt("max(salary)") + " Count==> " + rs.getInt("count(salary)"));
			con.close();
		} catch (SQLException e) {
			// Handle errors for JDBC
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public int addNewEmployeeToPayroll(int i, String string, String string2, String string3, String string4, float f,
//			float g, float h, float j, float k, String string5, String string6, String string7, int l) {
//		// TODO Auto-generated method stub
//		return 0;
//	}


	public int addNewEmployeeToPayroll(int EmployeeID, String EmployeeName, String Phonenumber, String Department,
			String gender, float BasicPay, float Deductions, float TaxablePay, float Tax, float NetPay, String address,LocalDate start_date, String City, String Country, int salary) throws SQLException {
		// TODO Auto-generated method stub
		String query = String.format(
					"INSERT INTO employee_payrolls (`EmployeeID`, `EmployeeName`,`Phonenumber`,`Department`,`gender`, `BasicPay`, `Deductions`,`TaxablePay`, `Tax`,`NetPay`,`address`,`start_date`,`City`,`Country`,`salary`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
					EmployeeID, EmployeeName, Phonenumber, Department, gender, BasicPay, Deductions, TaxablePay, Tax, NetPay,address ,start_date ,City,Country,salary);
			System.out.println(query);
			Connection con = null;

			int rs = 0;
			try {

				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				con.setAutoCommit(false);
				Statement statement = con.createStatement();
				rs = statement.executeUpdate(query);

				con.commit();

			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			}
			return rs;
	}
	
	public int addToPayrollDetailsToThePayroll(int employee_id, String employeeName, String employee_address, int salary) throws SQLException
	{
			String query = String.format(
					"INSERT INTO employee (`employee_id`, `employeeName`,`employee_address`,`salary`) VALUES ('%s','%s','%s','%s')",employee_id, employeeName, employee_address, salary);
			//String query1 = String.format(
				//	"INSERT INTO employee (`employee_id`, `employeeName`,`employee_address`,`salary`) VALUES ('%s','%s','%s','%s')",employee_id, employeeName, employee_address, salary);
			System.out.println(query);
			//System.out.println(query1);
			Connection con = null;
			int rs = 0;
			try {

				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				con.setAutoCommit(false);
				Statement statement = con.createStatement();
				rs = statement.executeUpdate(query);

				con.commit();

			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			}
			return rs;
	}
	
	
	public static void main(String args[]) {

		// jdbcconncetions();
		// retrieveEmployeePayroll();
		// updateSalary("Terissa", 3000000);
		// jdbcconncetions();
		System.out.println(list.size());
		// usingjdbcPrepardstatement(60000, "Gouthum");
		// refactorjdbcPrepardstatement();
		// findsumavgminmax();
		// retrieveEmployeeallDatarange(2021-10-25,2022-01-10);
	}

}
