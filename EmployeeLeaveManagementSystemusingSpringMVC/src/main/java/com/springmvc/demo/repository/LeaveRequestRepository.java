package com.springmvc.demo.repository;

import com.springmvc.demo.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    // Custom Query: Find Leave Requests By Employee ID
    List<LeaveRequest> findByEmployeeEmployeeId(Long employeeId);

}