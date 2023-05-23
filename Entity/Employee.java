package com.employee.leaves.employee.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long EmployeeId ;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	private long totalLeaves =10;
	private long leavesTaken;
	
	@OneToMany(mappedBy ="employee")
	private List<LeavesRequest> leaveRequests = new ArrayList<>();

	public long getId() {
		return EmployeeId;
	}

	public void setId(long id) {
		this.EmployeeId = id;
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

	public List<LeavesRequest> getLeaveRequests() {
		return leaveRequests;
	}

	public void setLeaveRequests(List<LeavesRequest> leaveRequests) {
		this.leaveRequests = leaveRequests;
	}

	public Employee(long id, String name, String email, long totalLeaves, long leavesTaken,
			List<LeavesRequest> leaveRequests) {
		super();
		this.EmployeeId = id;
		this.name = name;
		this.email = email;
		this.totalLeaves = totalLeaves;
		this.leavesTaken = leavesTaken;
		this.leaveRequests = leaveRequests;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + EmployeeId + ", name=" + name + ", email=" + email + ", totalLeaves=" + totalLeaves
				+ ", leavesTaken=" + leavesTaken + ", leaveRequests=" + leaveRequests + "]";
	}
	
	

}
