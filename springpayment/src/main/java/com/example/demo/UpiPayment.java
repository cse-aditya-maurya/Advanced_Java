package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements Payment {

    public UpiPayment() {
        System.out.println("UpiPayment Bean Created");
    }

    @Override
    public void pay(double amount) {
        System.out.println("UPI payment of Rs. " + amount + " successful");
    }
}