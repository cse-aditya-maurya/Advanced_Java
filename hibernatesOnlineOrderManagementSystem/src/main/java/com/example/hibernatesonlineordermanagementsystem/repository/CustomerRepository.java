package com.example.hibernatesonlineordermanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hibernatesonlineordermanagementsystem.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}