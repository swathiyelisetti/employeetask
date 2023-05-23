package com.employee.leaves.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee.leaves.employee.Entity.Employee;
import com.employee.leaves.employee.Repository.EmployeeRepository;
import com.employee.leaves.employee.dto.EmployeeDto;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	private EmployeeDto convertToDTO(Employee employee) {
        EmployeeDto employeeDTO = new EmployeeDto();
        employeeDTO.setEmployeeId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setTotalLeaves(employee.getTotalLeaves());
        employeeDTO.setLeavesTaken(employee.getLeavesTaken());
        return employeeDTO;
    }
	
	private Employee convertToEntity(EmployeeDto employeeDTO) {
	    Employee employee = new Employee();
	    employee.setId(employeeDTO.getEmployeeId());
	    employee.setName(employeeDTO.getName());
	    employee.setEmail(employeeDTO.getEmail());
	    employee.setTotalLeaves(employeeDTO.getTotalLeaves());
	    employee.setLeavesTaken(employeeDTO.getLeavesTaken());
	    // You can handle the leave requests conversion if needed
	    return employee;
	}

	public EmployeeDto createEmployeess(EmployeeDto employeeDTO) {
	Employee employee=	convertToEntity(employeeDTO);
	Employee savedData =employeeRepo.save(employee);
		return convertToDTO(savedData);
	}
	
	  public Page<EmployeeDto> getEmployeesPage(int pageNo, int pageSize) {
	        Pageable pageable = PageRequest.of(pageNo, pageSize);
	        Page<Employee> employeePage = employeeRepo.findAll(pageable);
	        List<EmployeeDto> employeeDTOList = employeePage.getContent()
	                .stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	        return new PageImpl<>(employeeDTOList, pageable, employeePage.getTotalElements());
//	        return (Page<EmployeeDto>) employeeDTOList;
	    }
}
