package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringappApplication {

    public static void main(String[] args) {

//        ApplicationContext context =
//                SpringApplication.run(SpringappApplication.class, args);
    	
    	BeanFactory factory=SpringApplication.run(SpringappApplication.class, args);
//    	we can write ApplicationContext or BeanFactory
    	
    	Vehicle vehicle=factory.getBean(Vehicle.class);
    	vehicle.run();
    	
//        System.out.println("Hello World");

//        Car car1 = context.getBean(Car.class);
//        Car car2 = context.getBean(Car.class);

//        System.out.println(car1);
//        System.out.println(car2);
//        Vehicle vehicle=context.getBean(Vehicle.class);
//          Vehicle vehicle=(Vehicle) context.getBean("car");
//        Bike bike=context.getBean(Bike.class);
        
//        vehicle.run();
         
    }
}



