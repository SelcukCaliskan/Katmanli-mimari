package com.selcuk.springcomplex1.business.dto;

public class EmployeeDetail {
	
	private long employeeId;
	
	private String employeeName;
	
	private double montlySalary;
	
	private long departmentId;
	
	private String departmentName;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getMontlySalary() {
		return montlySalary;
	}

	public void setMontlySalary(double montlySalary) {
		this.montlySalary = montlySalary;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	

	
}
