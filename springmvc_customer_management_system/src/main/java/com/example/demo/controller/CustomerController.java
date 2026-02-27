package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;

    // Show Add Customer Form
    @GetMapping("/addCustomer")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    // Save Customer
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        service.saveCustomer(customer);
        return "redirect:/customers";
    } 

    // Show All Customers
    @GetMapping("/customers")
    public String viewCustomers(Model model) {
        model.addAttribute("customers", service.getAllCustomers());
        return "customer-list";
    }
    
    // Edit Customer
    @GetMapping("/editCustomer/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        Customer customer = service.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "add-customer";
    }

    // Delete Customer
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
        return "redirect:/customers";
    }
}