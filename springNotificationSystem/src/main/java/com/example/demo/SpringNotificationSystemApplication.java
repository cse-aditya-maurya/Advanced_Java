package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringNotificationSystemApplication {

	public static void main(String[] args) {
		
	       // Load container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("Container Started");

        // Get email bean
        Notification email = (Notification) context.getBean("emailBean");
        email.send("Welcome Email!");

        System.out.println("--------------------");

        // Get sms bean
        Notification sms = (Notification) context.getBean("smsBean");
        sms.send("Welcome SMS!");

        // Close container
        context.close();
	}

}
