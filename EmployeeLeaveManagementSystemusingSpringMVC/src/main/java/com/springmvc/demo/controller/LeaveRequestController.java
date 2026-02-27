package com.springmvc.demo.controller;

import com.springmvc.demo.model.LeaveRequest;
import com.springmvc.demo.service.EmployeeService;
import com.springmvc.demo.service.LeaveRequestService;
import com.springmvc.demo.service.LeaveTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveTypeService leaveTypeService;

    // View all leave requests
    @GetMapping
    public String viewLeaves(Model model) {
        model.addAttribute("leaves", leaveRequestService.getAllLeaveRequests());
        return "leave-list";
    }

    // Show apply form
    @GetMapping("/apply")
    public String showApplyForm(Model model) {
        model.addAttribute("leaveRequest", new LeaveRequest());
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        model.addAttribute("leaveTypeList", leaveTypeService.getAllLeaveTypes());
        return "leave-form";
    }

    // Save leave request
    @PostMapping("/save")
    public String saveLeave(@ModelAttribute LeaveRequest leaveRequest) {
        leaveRequest.setStatus("Pending");
        leaveRequestService.saveLeaveRequest(leaveRequest);
        return "redirect:/leaves";
    }
}