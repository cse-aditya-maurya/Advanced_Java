package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringpaymentApplication {

	public static void main(String[] args) {
//		  AnnotationConfigApplicationContext context =
//	                new AnnotationConfigApplicationContext("com.example.demo");
		  ConfigurableApplicationContext context =
	                SpringApplication.run(SpringpaymentApplication.class, args);

	        // Get default Payment bean (CreditCardPayment)
	
	        Payment payment = context.getBean(Payment.class);
	        payment.pay(5000);

	        System.out.println("--------------------------------");

	        // Get UpiPayment bean twice
	        UpiPayment upi1 = context.getBean(UpiPayment.class);
	        UpiPayment upi2 = context.getBean(UpiPayment.class);

	        upi1.pay(1000);
	        upi2.pay(2000);

	        System.out.println("Are both UPI beans same? " + (upi1 == upi2));

	        // Close container
	        context.close();
	}

}
