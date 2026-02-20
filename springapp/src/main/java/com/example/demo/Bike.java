package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary
public class Bike implements Vehicle {
	@Override
	
  public  void run() {
	   System.out.println("Bike is running");
   }
}


