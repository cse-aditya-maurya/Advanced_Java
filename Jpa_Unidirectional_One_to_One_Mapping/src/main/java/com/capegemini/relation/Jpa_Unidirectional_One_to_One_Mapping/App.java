package com.capegemini.relation.Jpa_Unidirectional_One_to_One_Mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Create locker
        Locker locker = new Locker("L-101", 2);

        // Create employee and assign locker
        Employee employee = new Employee("Aditya", "IT", locker);

        // Save employee (locker saved automatically via cascade)
        session.persist(employee);

        tx.commit();

        // Fetch employee
        Employee fetched = session.get(Employee.class, employee.getEmployeeId());

        System.out.println("Employee Name: " + fetched.getName());
        System.out.println("Department: " + fetched.getDepartment());
        System.out.println("Locker: " +
                fetched.getLocker().getLockerNumber() +
                ", Floor: " +
                fetched.getLocker().getFloor());

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
