package com.employee.leaves.employee.dto;

import java.time.LocalDate;


public class LeavesRequestDto {
	private long leaveId ;
	private LocalDate startDate;
	private LocalDate endDate;
	private String Status;
//	 private long employeeId;
//	public long getEmployeeId() {
//		return employeeId;
//	}
//	public void setEmployeeId(long employeeId) {
//		this.employeeId = employeeId;
//	}
	public long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
