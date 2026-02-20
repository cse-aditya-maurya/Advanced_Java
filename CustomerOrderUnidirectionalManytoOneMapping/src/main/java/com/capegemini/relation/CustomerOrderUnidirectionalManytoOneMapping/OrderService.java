package com.capegemini.relation.CustomerOrderUnidirectionalManytoOneMapping;

import jakarta.persistence.*;
import java.time.LocalDate;

public class OrderService {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("orderPU");

    public Customer createCustomer(String name, String email) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer = new Customer(name, email);
        em.persist(customer);

        em.getTransaction().commit();
        em.close();
        return customer;
    }

    public void createOrder(Customer customer, double amount) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Order order = new Order(LocalDate.now(), amount, customer);
        em.persist(order);

        em.getTransaction().commit();
        em.close();
    }

    public void fetchOrder(Long orderId) {
        EntityManager em = emf.createEntityManager();

        Order order = em.find(Order.class, orderId);

        System.out.println("Order Details: " + order);
        System.out.println("Customer Details: " + order.getCustomer());

        em.close();
    }

    public void close() {
        emf.close();
    }
}
