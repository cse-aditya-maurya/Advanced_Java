package com.capegemini.relation.EmployeeandIDCardManagementSystem;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private IDCard idCard;

    public Employee() {}

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public IDCard getIdCard() { return idCard; }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
        idCard.setEmployee(this);
    }
}
