package com.employee.leaves.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.leaves.employee.dto.EmployeeDto;
import com.employee.leaves.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/insertEmp")
	public ResponseEntity<EmployeeDto> registerEmployee(@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<>(employeeService.createEmployeess(employeeDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/employeepage")
	public ResponseEntity<Page<EmployeeDto>> getEmployeesPage(
	        @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
	        @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
	    Page<EmployeeDto> employeePage = employeeService.getEmployeesPage(pageNo, pageSize);
	    return ResponseEntity.ok(employeePage);
	}

}
