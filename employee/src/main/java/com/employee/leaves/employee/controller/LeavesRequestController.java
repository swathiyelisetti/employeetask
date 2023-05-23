package com.employee.leaves.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.leaves.employee.dto.LeavesRequestDto;
import com.employee.leaves.employee.service.LeavesRequestService;


@RestController
public class LeavesRequestController {
	
	@Autowired
	LeavesRequestService leavesService;

	@PostMapping("/leaverequest{employeeId}")
	public ResponseEntity<LeavesRequestDto> RequestForLeave(@PathVariable long employeeId,@RequestBody LeavesRequestDto leavesDto){
		return  new ResponseEntity<>(leavesService.saveleaves(employeeId, leavesDto),HttpStatus.CREATED);
	
	}
}
