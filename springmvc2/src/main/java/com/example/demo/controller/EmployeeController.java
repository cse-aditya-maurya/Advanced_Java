package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.demo.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployeeDetails(Model model) {

        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);

        return "employee";
    }
    
//   @GetMapping("/employees1")
//   public ModelAndView getEmployeeDetails() {
//	   List<Employee> employees1 = employeeService.getAllEmployee();
//	   ModelAndView mv=new ModelAndView();
//	   mv.addObject("employees",employees1);
//	   mv.setViewName("employee");
//	   return mv;
//	   
//   }
    
    

    @GetMapping("/addEmployee")
    public String showAddform(Model model) {

       
        model.addAttribute("employee", new Employee());

        return "addEmployee";
    }
    
//    @GetMapping("/saveEmployee")
//    public String saveEmployee(Employee employee) {
//    	employeeService.saveEmployee(employee);
//    	return "redirect:/employees";
// }
    
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }
}