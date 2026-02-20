package com.capegemini.relation.CustomerOrderUnidirectionalManytoOneMapping;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;
    private String email;

    public Customer() {}

    public Customer(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
    }

    public Long getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getEmail() { return email; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Customer{id=" + customerId +
                ", name='" + customerName +
                "', email='" + email + "'}";
    }
}
