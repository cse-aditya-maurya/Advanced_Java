package com.springmvc.demo.controller;

import com.springmvc.demo.model.LeaveType;
import com.springmvc.demo.service.LeaveTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/leave-types")
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }

    // View All Leave Types
    @GetMapping
    public String listLeaveTypes(Model model) {
        model.addAttribute("leaveTypeList", leaveTypeService.getAllLeaveTypes());
        return "leave-type-list";
    }

    // Show Add Form
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("leaveType", new LeaveType());
        return "leave-type-form";
    }

    // Save Leave Type
    @PostMapping("/save")
    public String saveLeaveType(@ModelAttribute LeaveType leaveType) {
        leaveTypeService.saveLeaveType(leaveType);
        return "redirect:/leave-types";
    }

    // Delete Leave Type
    @GetMapping("/delete/{id}")
    public String deleteLeaveType(@PathVariable Long id) {
        leaveTypeService.deleteLeaveType(id);
        return "redirect:/leave-types";
    }
}