package com.selcuk.springcomplex1.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	private String employeeName;
	private double montlySalary;
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	//Burda her employee nin bir departmanı olur demek.
	
	public long getEmployeeId() {
		return employeeId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	
	
	
	
	

}
