package com.example.demo;
public class SmsNotification implements Notification {

    public SmsNotification() {
        System.out.println("SmsNotification Bean Created");
    }

    @Override
    public void send(String message) {
        System.out.println("SMS Notification sent: " + message);
    }
}