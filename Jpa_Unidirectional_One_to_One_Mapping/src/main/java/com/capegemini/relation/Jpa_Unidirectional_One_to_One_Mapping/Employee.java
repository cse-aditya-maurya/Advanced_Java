package com.capegemini.relation.Jpa_Unidirectional_One_to_One_Mapping;

import jakarta.persistence.*;

@Entity  
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    private String name;
    private String department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locker_id")
    private Locker locker;

    public Employee() {} 

    public Employee(String name, String department, Locker locker) {
        this.name = name;
        this.department = department;
        this.locker = locker;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Locker getLocker() {
        return locker;
    }
}
