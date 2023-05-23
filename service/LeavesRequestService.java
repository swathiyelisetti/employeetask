package com.employee.leaves.employee.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.leaves.employee.Entity.Employee;
import com.employee.leaves.employee.Entity.LeavesRequest;
import com.employee.leaves.employee.Exception.EmployeeNotFound;
import com.employee.leaves.employee.Repository.EmployeeRepository;
import com.employee.leaves.employee.Repository.LeaveRequestRepository;
import com.employee.leaves.employee.dto.LeavesRequestDto;

@Service
public class LeavesRequestService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired
	LeaveRequestRepository leaveRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	private LeavesRequest convertToEntity(LeavesRequestDto leaveRequestDTO) {
		LeavesRequest leaveRequest = new LeavesRequest();
	    leaveRequest.setLeaveId(leaveRequestDTO.getLeaveId());
	    leaveRequest.setStartDate(leaveRequestDTO.getStartDate());
	    leaveRequest.setEndDate(leaveRequestDTO.getEndDate());
	    leaveRequest.setStatus(leaveRequestDTO.getStatus());
	    // You can handle the employee association if needed
	    return leaveRequest;
	}
	private LeavesRequestDto convertToDTO(LeavesRequest leaveRequest) {
		LeavesRequestDto leaveRequestDTO = new LeavesRequestDto();
	    leaveRequestDTO.setLeaveId(leaveRequest.getLeaveId());
	    leaveRequestDTO.setStartDate(leaveRequest.getStartDate());
	    leaveRequestDTO.setEndDate(leaveRequest.getEndDate());
	    leaveRequestDTO.setStatus(leaveRequest.getStatus());
	    return leaveRequestDTO;
	}
	
	public LeavesRequestDto saveleaves(long employeeid, LeavesRequestDto leavesDto) {
		Employee employee =employeeRepo.findById((int) employeeid)
				.orElseThrow(() -> new EmployeeNotFound(String.format("Employee Id %d not found ", employeeid)));
		long leavesTaken =employee.getLeavesTaken();
		// if leaves are over it will throw a expection
		if(leavesTaken>=10&& leavesTaken<0) {
	throw new EmployeeNotFound(String.format("Employee Id %d not found "));
		}
		else {
			LeavesRequest leaveRequest = modelMapper.map(leavesDto, LeavesRequest.class);
			 LocalDate startDate = leavesDto.getStartDate();
		        LocalDate endtDate = leavesDto.getEndDate();
			Long range = ChronoUnit.DAYS.between(startDate, endtDate);
			System.out.println(range);
			employee.setLeavesTaken(range);
			leaveRequest.setEmployee(employee);
			LeavesRequest savedLeaves = leaveRepo.save(leaveRequest);
			return modelMapper.map(savedLeaves, LeavesRequestDto.class);
		}
	}

}
