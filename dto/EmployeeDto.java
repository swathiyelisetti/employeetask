package com.employee.leaves.employee.dto;


public class EmployeeDto {
	private long EmployeeId ;
	private String name;
	private String email;
	private long totalLeaves =10;
	private long leavesTaken;
	public long getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(long employeeId) {
		EmployeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTotalLeaves() {
		return totalLeaves;
	}
	public void setTotalLeaves(long totalLeaves) {
		this.totalLeaves = totalLeaves;
	}
	public long getLeavesTaken() {
		return leavesTaken;
	}
	public void setLeavesTaken(long leavesTaken) {
		this.leavesTaken = leavesTaken;
	}
	

}
