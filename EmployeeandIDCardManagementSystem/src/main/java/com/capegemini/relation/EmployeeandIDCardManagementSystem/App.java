package com.capegemini.relation.EmployeeandIDCardManagementSystem;

import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("employeePU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee emp = new Employee("John", "john@example.com");
        IDCard card = new IDCard("IDC101", LocalDate.now());

        emp.setIdCard(card);

        em.persist(emp);

        em.getTransaction().commit();

        System.out.println("Employee Created Successfully");

        Employee fetchedEmp = em.find(Employee.class, emp.getId());

        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + fetchedEmp.getId());
        System.out.println("Name: " + fetchedEmp.getName());
        System.out.println("Email: " + fetchedEmp.getEmail());

        IDCard fetchedCard = fetchedEmp.getIdCard();

        System.out.println("\nID Card Details:");
        System.out.println("Card Number: " + fetchedCard.getCardNumber());
        System.out.println("Issue Date: " + fetchedCard.getIssueDate());

        IDCard cardAgain = em.find(IDCard.class, fetchedCard.getId());

//        System.out.println("\nEmployee from IDCard:");
//        System.out.println(cardAgain.getEmployee().getName());

        em.close();
        emf.close();
    }
}
