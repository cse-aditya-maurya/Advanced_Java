package com.example.hibernatesonlineordermanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hibernatesonlineordermanagementsystem.service.OrderService;

@SpringBootApplication
public class HibernatesOnlineOrderManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(HibernatesOnlineOrderManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.saveData();
        orderService.fetchData();
    }
}