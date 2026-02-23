package com.example.hibernatesonlineordermanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.hibernatesonlineordermanagementsystem.entity.Customer;
import com.example.hibernatesonlineordermanagementsystem.entity.Order;
import com.example.hibernatesonlineordermanagementsystem.entity.OrderItem;
import com.example.hibernatesonlineordermanagementsystem.repository.CustomerRepository;

@Service
public class OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    // ================= SAVE DATA =================
    public void saveData() {

        // 1️⃣ Create Customer
        Customer customer = new Customer();
        customer.setCustomerName("Aditya");
        customer.setEmail("aditya@gmail.com");

        // 2️⃣ Create Order 1
        Order order1 = new Order();
        order1.setOrderDate(LocalDate.now());
        order1.setTotalAmount(70000);
        order1.setCustomer(customer);

        // 3️⃣ Create OrderItems for Order 1
        OrderItem item1 = new OrderItem();
        item1.setProductName("Laptop");
        item1.setQuantity(1);
        item1.setPrice(70000);
        item1.setOrder(order1);

        OrderItem item2 = new OrderItem();
        item2.setProductName("Mouse");
        item2.setQuantity(2);
        item2.setPrice(500);
        item2.setOrder(order1);

        order1.setOrderItems(Arrays.asList(item1, item2));

        // 4️⃣ Create Order 2
        Order order2 = new Order();
        order2.setOrderDate(LocalDate.now());
        order2.setTotalAmount(3000);
        order2.setCustomer(customer);

        OrderItem item3 = new OrderItem();
        item3.setProductName("Keyboard");
        item3.setQuantity(1);
        item3.setPrice(3000);
        item3.setOrder(order2);

        order2.setOrderItems(Arrays.asList(item3));

        // 5️⃣ Attach Orders to Customer
        customer.setOrders(Arrays.asList(order1, order2));

        // 6️⃣ Save Customer (Cascade saves everything)
        customerRepository.save(customer);

        System.out.println("Data Saved Successfully ✅");
    }

    // ================= FETCH DATA =================
    public void fetchData() {

        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getCustomerName());
            System.out.println("Email: " + customer.getEmail());

            for (Order order : customer.getOrders()) {
                System.out.println("  Order ID: " + order.getOrderId());
                System.out.println("  Total Amount: " + order.getTotalAmount());

                for (OrderItem item : order.getOrderItems()) {
                    System.out.println("     Item: " + item.getProductName());
                    System.out.println("     Quantity: " + item.getQuantity());
                    System.out.println("     Price: " + item.getPrice());
                }
            }
            System.out.println("----------------------------------");
        }
    }
}