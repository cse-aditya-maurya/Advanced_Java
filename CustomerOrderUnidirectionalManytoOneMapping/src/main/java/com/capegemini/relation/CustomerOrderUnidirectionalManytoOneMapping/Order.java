package com.capegemini.relation.CustomerOrderUnidirectionalManytoOneMapping;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private LocalDate orderDate;
    private double totalAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {}

    public Order(LocalDate orderDate, double totalAmount, Customer customer) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    public Long getOrderId() { return orderId; }
    public LocalDate getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public Customer getCustomer() { return customer; }

    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    @Override
    public String toString() {
        return "Order{id=" + orderId +
                ", date=" + orderDate +
                ", total=" + totalAmount + "}";
    }
}
