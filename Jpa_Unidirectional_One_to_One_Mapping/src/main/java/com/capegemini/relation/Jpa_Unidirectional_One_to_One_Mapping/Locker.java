package com.capegemini.relation.Jpa_Unidirectional_One_to_One_Mapping;

import jakarta.persistence.*;

@Entity
@Table(name = "lockers")
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locker_id")
    private int lockerId;

    @Column(name = "locker_number")
    private String lockerNumber;

    @Column(name = "floor")
    private int floor;

    // Required by Hibernate
    public Locker() {}

    // Constructor you are calling in App.java
    public Locker(String lockerNumber, int floor) {
        this.lockerNumber = lockerNumber;
        this.floor = floor;
    }

    public int getLockerId() {
        return lockerId;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setLockerNumber(String lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
