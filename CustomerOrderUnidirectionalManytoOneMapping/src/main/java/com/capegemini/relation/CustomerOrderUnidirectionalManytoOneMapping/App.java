package com.capegemini.relation.CustomerOrderUnidirectionalManytoOneMapping;

public class App {

    public static void main(String[] args) {

        OrderService service = new OrderService();

        // Create customer
        Customer cust = service.createCustomer("Alice Smith", "alice@example.com");

        // Create multiple orders
        service.createOrder(cust, 250.75);
        service.createOrder(cust, 99.99);

        // Retrieve an order
        service.fetchOrder(1L);

        service.close();
    }
}
