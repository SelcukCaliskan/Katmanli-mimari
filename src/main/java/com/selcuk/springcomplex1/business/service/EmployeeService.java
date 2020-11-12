package com.selcuk.springcomplex1.business.service;

import com.selcuk.springcomplex1.business.dto.EmployeeDetail;
import com.selcuk.springcomplex1.business.dto.EmployeeSummary;

public interface EmployeeService {

	public void save(EmployeeDetail employeeDetail);
	
	public void update (EmployeeDetail employeeDetail);
	
	public void delete (long employeeId);
	
	public EmployeeDetail find(Long employeeId);
	
	public EmployeeSummary list();
	
	public EmployeeSummary listByDepartment(long departmentId);
	
	public int countByDepartment(long departmentId);
	
	
}
