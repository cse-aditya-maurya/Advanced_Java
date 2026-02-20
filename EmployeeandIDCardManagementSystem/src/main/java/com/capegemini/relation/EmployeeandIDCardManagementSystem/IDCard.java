package com.capegemini.relation.EmployeeandIDCardManagementSystem;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class IDCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cardNumber;
    private LocalDate issueDate;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public IDCard() {}

    public IDCard(String cardNumber, LocalDate issueDate) {
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
    }

    public int getId() { return id; }
    public String getCardNumber() { return cardNumber; }
    public LocalDate getIssueDate() { return issueDate; }
    public Employee getEmployee() { return employee; }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
