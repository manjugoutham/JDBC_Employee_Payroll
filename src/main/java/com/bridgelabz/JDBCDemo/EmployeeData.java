package com.bridgelabz.JDBCDemo;

import java.time.LocalDate;

public class EmployeeData {
	
	int EmployeeID,salary;
	float BasicPay,Deductions,TaxiavlePay,Tax,NetPay;
	String EmployeeName,Phonenumber,Department,City,Country,address;
	char gender; 
	LocalDate start_date;
	
	public EmployeeData()
	{
		
	}

	public EmployeeData(int employeeID, int salary, float basicPay, float deductions, float taxiavlePay, float tax,
			float netPay, String employeeName, String phonenumber, String department, String city, String country,
			String address, char gender, LocalDate start_date) {
		super();
		EmployeeID = employeeID;
		this.salary = salary;
		BasicPay = basicPay;
		Deductions = deductions;
		TaxiavlePay = taxiavlePay;
		Tax = tax;
		NetPay = netPay;
		EmployeeName = employeeName;
		Phonenumber = phonenumber;
		Department = department;
		City = city;
		Country = country;
		this.address = address;
		this.gender = gender;
		this.start_date = start_date;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public float getBasicPay() {
		return BasicPay;
	}

	public void setBasicPay(float basicPay) {
		BasicPay = basicPay;
	}

	public float getDeductions() {
		return Deductions;
	}

	public void setDeductions(float deductions) {
		Deductions = deductions;
	}

	public float getTaxiavlePay() {
		return TaxiavlePay;
	}

	public void setTaxiavlePay(float taxiavlePay) {
		TaxiavlePay = taxiavlePay;
	}

	public float getTax() {
		return Tax;
	}

	public void setTax(float tax) {
		Tax = tax;
	}

	public float getNetPay() {
		return NetPay;
	}

	public void setNetPay(float netPay) {
		NetPay = netPay;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getPhonenumber() {
		return Phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	@Override
	public String toString() {
		return "EmployeeData [EmployeeID=" + EmployeeID + ", salary=" + salary + ", BasicPay=" + BasicPay
				+ ", Deductions=" + Deductions + ", TaxiavlePay=" + TaxiavlePay + ", Tax=" + Tax + ", NetPay=" + NetPay
				+ ", EmployeeName=" + EmployeeName + ", Phonenumber=" + Phonenumber + ", Department=" + Department
				+ ", City=" + City + ", Country=" + Country + ", address=" + address + ", gender=" + gender
				+ ", start_date=" + start_date + "]";
	}
	
	
}
