package com.employee.leaves.employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//404
public class EmployeeNotFound extends RuntimeException{
private String message;
	
	public EmployeeNotFound(String message) {
		super(message);
		this.message= message;	
	}

}
