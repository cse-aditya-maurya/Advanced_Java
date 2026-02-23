package com.example.demo;


public class EmailNotification implements Notification {

    public EmailNotification() {
        System.out.println("EmailNotification Bean Created");
    }

    public void init() {
        System.out.println("EmailNotification Bean Initialized");
    }

    public void destroy() {
        System.out.println("EmailNotification Bean Destroyed");
    }

    @Override
    public void send(String message) {
        System.out.println("Email Notification sent: " + message);
    }
}


