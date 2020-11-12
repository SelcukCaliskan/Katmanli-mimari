package com.selcuk.springcomplex1.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//Bu deneme bi class index önemli çünkü veri tabanı yavaşlayabilir.
//@Entity
@Table(indexes = {
		//Ada göre işlem yapılacak
		@Index(columnList = "employeeName"),
		//index ismi verdik
		@Index(name = "myindex" , columnList = "employeeName"),
		//unique olmak zorunda 
		@Index( columnList = "employeeName",unique = true),
		//birden fazla olabilir
		@Index( columnList = "employeeName, montlySalary")
},
//İndex maliyetlidir ama sadece unik olsun dersen bunu kullanırsın.
uniqueConstraints = @UniqueConstraint(columnNames = "montlySalary")
)

public class Searched {
	
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
	
	