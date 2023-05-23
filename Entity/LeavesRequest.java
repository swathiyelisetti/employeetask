package com.employee.leaves.employee.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "leaverequests")
public class LeavesRequest {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leaveId ;
	private LocalDate startDate;
	private LocalDate endDate;
	@Column(nullable = false)
	private String Status;
	
	@ManyToOne
	@JoinColumn(name = "employeeid")
	private Employee employee;


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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LeavesRequest(long id, LocalDate startDate, LocalDate endDate, String status, Employee employee) {
		super();
		this.leaveId = id;
		this.startDate = startDate;
		this.endDate = endDate;
		Status = status;
		this.employee = employee;
	}

	public LeavesRequest() {
		super();
	}

	@Override
	public String toString() {
		return "LeavesRequest [id=" + leaveId + ", startDate=" + startDate + ", endDate=" + endDate + ", Status=" + Status
				+ ", employee=" + employee + "]";
	}
	
	

}
