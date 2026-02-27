package com.springmvc.demo.service;

import com.springmvc.demo.model.LeaveRequest;
import com.springmvc.demo.model.LeaveType;
import com.springmvc.demo.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    // Save Leave Request
    public LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest) {

        // Business Logic: Validate Max Leave Days
        LeaveType leaveType = leaveRequest.getLeaveType();

        long days = ChronoUnit.DAYS.between(
                leaveRequest.getStartDate(),
                leaveRequest.getEndDate()
        ) + 1;

        if (days > leaveType.getMaxDaysAllowed()) {
            throw new RuntimeException("Leave exceeds maximum allowed days!");
        }

        leaveRequest.setStatus("Pending");

        return leaveRequestRepository.save(leaveRequest);
    }

    // Get All Leave Requests
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    // Get Leave Request By ID
    public LeaveRequest getLeaveRequestById(Long id) {
        Optional<LeaveRequest> request = leaveRequestRepository.findById(id);
        return request.orElse(null);
    }

    // Approve Leave
    public void approveLeave(Long id) {
        LeaveRequest request = getLeaveRequestById(id);
        if (request != null) {
            request.setStatus("Approved");
            leaveRequestRepository.save(request);
        }
    }

    // Reject Leave
    public void rejectLeave(Long id) {
        LeaveRequest request = getLeaveRequestById(id);
        if (request != null) {
            request.setStatus("Rejected");
            leaveRequestRepository.save(request);
        }
    }

    // Delete Leave Request
    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}