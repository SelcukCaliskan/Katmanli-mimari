package com.selcuk.springcomplex1.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.selcuk.springcomplex1.business.dto.DepartmentSummary;
import com.selcuk.springcomplex1.business.dto.EmployeeDetail;
import com.selcuk.springcomplex1.business.dto.EmployeeSummary;
import com.selcuk.springcomplex1.business.service.DepartmentService;
import com.selcuk.springcomplex1.business.service.EmployeeService;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping(path = {"/employee/edit","/employee/edit/{id}"})
	public String editEmployee(Model model ,
			@PathVariable(name ="id",required =false)Long employeeId) {
		EmployeeDetail employee=employeeService.find(employeeId);
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("employee" , employee);
		model.addAttribute("departments", departments);
		return "/human/EmployeeEdit";
		
	}
	
	
	@PostMapping(path = {"/employee/edit","/employee/edit/{id}"})
	public String editEmployee(Model model,EmployeeDetail employee,BindingResult result) {
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("employee" , employee);
		model.addAttribute("departments", departments);
		if(result.hasErrors()) {
			result.addError(new ObjectError(
					"employee","Biçimde bir takım yanlışlıklar var!"));
			return "/human/EmployeeEdit";

		}
		employeeService.save(employee);
		model.addAttribute("message","Başarılı bir şekilde saklandı");
		model.addAttribute("employee",employee);
		return "/human/EmployeeSuccess";
		
		
	}
	
	
	@GetMapping("/employee/list")
	public String getEmployeeList(Model model) {
		EmployeeSummary employees=employeeService.list();
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		model.addAttribute("employees",employees);
		model.addAttribute("message" , "Çalışanlar");
		return "/human/EmployeeList";
	}
	
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(Model model,
			@PathVariable ("id") long employeeId) {
		employeeService.delete(employeeId);
		model.addAttribute("message" ,"Ürün silindi");
		EmployeeSummary employees=employeeService.list();
		model.addAttribute("employees" , employees);
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		return "/human/EmployeeList";
	}
	
	
	@PostMapping("/employee/list")
	public String editEmployee(Model model,EmployeeSummary employees,BindingResult result) {
		if(employees.getDepartmentId()==0) {
			employees=employeeService.list();
		}else {
			employees=employeeService.listByDepartment(employees.getDepartmentId());
		}
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		model.addAttribute("message","Ürünler");
		model.addAttribute("employees",employees);
		return "/human/EmployeeList";
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
