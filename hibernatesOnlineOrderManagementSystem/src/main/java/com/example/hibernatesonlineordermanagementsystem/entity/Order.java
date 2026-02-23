package com.example.hibernatesonlineordermanagementsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    private LocalDate orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    // Many Orders -> One Customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // One Order -> Many OrderItems
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    // Getters and Setters
}