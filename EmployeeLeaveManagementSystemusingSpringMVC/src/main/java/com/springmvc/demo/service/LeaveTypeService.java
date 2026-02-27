package com.springmvc.demo.service;

import com.springmvc.demo.model.LeaveType;
import com.springmvc.demo.repository.LeaveTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveTypeService {

    private final LeaveTypeRepository leaveTypeRepository;

    public LeaveTypeService(LeaveTypeRepository leaveTypeRepository) {
        this.leaveTypeRepository = leaveTypeRepository;
    }

    // Save Leave Type
    public LeaveType saveLeaveType(LeaveType leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    // Get All Leave Types
    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    // Get Leave Type By ID
    public LeaveType getLeaveTypeById(Long id) {
        Optional<LeaveType> leaveType = leaveTypeRepository.findById(id);
        return leaveType.orElse(null);
    }

    // Delete Leave Type
    public void deleteLeaveType(Long id) {
        leaveTypeRepository.deleteById(id);
    }
}