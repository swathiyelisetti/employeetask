package com.employee.leaves.employee.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.leaves.employee.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Page<Employee> findAll(Pageable pageable);

}
