package com.employee.leaves.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.leaves.employee.Entity.LeavesRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeavesRequest, Integer> {

}
