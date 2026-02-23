package com.example.hibernatesonlineordermanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "product_name")
    private String productName;

    private int quantity;

    private double price;

    // Many OrderItems -> One Order
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Getters and Setters
}