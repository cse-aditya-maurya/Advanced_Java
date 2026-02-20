package com.capegemini.relation.OneToManyUnidirectional;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "dept_id")
    private int id;

    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id") // FK in employee table
    private List<Employee> employees;

    public Department() {}

    public Department(int id, String name, String location, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employees=" + employees +
                '}';
    }
}
