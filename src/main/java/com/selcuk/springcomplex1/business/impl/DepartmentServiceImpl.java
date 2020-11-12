package com.selcuk.springcomplex1.business.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selcuk.springcomplex1.business.dto.DepartmentDetail;
import com.selcuk.springcomplex1.business.dto.DepartmentSummary;
import com.selcuk.springcomplex1.business.dto.EmployeeDetail;
import com.selcuk.springcomplex1.business.dto.EmployeeSummary;
import com.selcuk.springcomplex1.business.service.DepartmentService;
import com.selcuk.springcomplex1.data.entity.Department;
import com.selcuk.springcomplex1.data.entity.Employee;
import com.selcuk.springcomplex1.data.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentSummary list() {
		DepartmentSummary departmentSummary = new DepartmentSummary();
		departmentSummary.setDepartmentDetailList(new ArrayList<>());
		for(Department department : departmentRepository.findAll()) {
			DepartmentDetail departmentDetail =toDto(department);
			departmentSummary.getDepartmentDetailList().add(departmentDetail);
			
		}
		
		return departmentSummary;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private DepartmentDetail toDto(Department department) {
		DepartmentDetail departmentDetail=new DepartmentDetail();
		departmentDetail.setDepartmentId(department.getDepartmentId());
		departmentDetail.setDepartmentName(department.getDepartmentName());
		

		return departmentDetail;
		
	}
	
	
		
		
		


	
	
	
	
	
	
	
	
	
	
	
	
}
