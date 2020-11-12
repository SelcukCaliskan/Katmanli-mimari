package com.selcuk.springcomplex1.business.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selcuk.springcomplex1.business.dto.EmployeeDetail;
import com.selcuk.springcomplex1.business.dto.EmployeeSummary;
import com.selcuk.springcomplex1.business.service.EmployeeService;
import com.selcuk.springcomplex1.data.entity.Department;
import com.selcuk.springcomplex1.data.entity.Employee;
import com.selcuk.springcomplex1.data.repository.DepartmentRepository;
import com.selcuk.springcomplex1.data.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void save(EmployeeDetail employeeDetail) {
		Employee employee =toEntity(employeeDetail);
		employeeRepository.save(employee);
		employeeDetail.setEmployeeId(employee.getEmployeeId());
		
	}

	@Override
	public void update(EmployeeDetail employeeDetail) {
		Employee employee =toEntity(employeeDetail);
		employeeRepository.save(employee);
	}

	@Override
	public void delete(long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public EmployeeDetail find(Long employeeId) {
		EmployeeDetail employeeDetail=null;
		if(employeeId != null) {
			Optional <Employee> employee=employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
		   employeeDetail = toDto(employee.get());	
			return employeeDetail;
		}
		}
		if(employeeDetail ==null) {
			employeeDetail=new EmployeeDetail();
			employeeDetail.setEmployeeName("");
			
		}
		
		return employeeDetail;
	}

	@Override
	public EmployeeSummary list() {
		EmployeeSummary employeeSummary=new EmployeeSummary();
		employeeSummary.setEmployeeDetailList(new ArrayList<>());
		for(Employee employee : employeeRepository.findAll()) {
			EmployeeDetail employeeDetail=toDto(employee);
			employeeSummary.getEmployeeDetailList().add(employeeDetail);
		}
		return employeeSummary;
	}

	@Override
	public EmployeeSummary listByDepartment(long departmentId) {
		EmployeeSummary employeeSummary=new EmployeeSummary();
		Optional <Department> department = departmentRepository.findById(departmentId);
		if(department.isPresent()) {
			employeeSummary.setDepartmentId(department.get().getDepartmentId());
			employeeSummary.setDepartmentName(department.get().getDepartmentName());

		}
		employeeSummary.setEmployeeDetailList(new ArrayList<>());
		for(Employee employee : employeeRepository.findByDepartment(departmentId)) {
			EmployeeDetail employeeDetail=toDto(employee);
			employeeSummary.getEmployeeDetailList().add(employeeDetail);
		}
		return employeeSummary;
	}

	@Override
	public int countByDepartment(long departmentId) {
		return employeeRepository.countByDepartment(departmentId);
	}
	
	private Employee toEntity(EmployeeDetail employeeDetail) {
		Employee employee =new Employee();
		employee.setEmployeeId(employeeDetail.getEmployeeId());
		employee.setEmployeeName(employeeDetail.getEmployeeName());
		employee.setMontlySalary(employeeDetail.getMontlySalary());
		
		if(employeeDetail.getDepartmentId() !=0) {
			Optional <Department> department = departmentRepository.findById(employeeDetail.getDepartmentId());
			if(department.isPresent()) {
				employee.setDepartment(department.get());
				
			}
			
		}
		return employee;
	}
	
	
	
	private EmployeeDetail toDto(Employee employee) {
		EmployeeDetail employeeDetail =new EmployeeDetail();
		employeeDetail.setEmployeeId(employee.getEmployeeId());
		employeeDetail.setEmployeeName(employee.getEmployeeName());
		employeeDetail.setMontlySalary(employee.getMontlySalary());
		
		if(employee.getDepartment() !=null) {
			employeeDetail.setDepartmentId(employee.getDepartment().getDepartmentId());	
			employeeDetail.setDepartmentName(employee.getDepartment().getDepartmentName());	

			
		}
		return employeeDetail;
	}

	
	
	
}








