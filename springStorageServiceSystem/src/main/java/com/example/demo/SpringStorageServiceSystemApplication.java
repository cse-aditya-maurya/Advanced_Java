package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringStorageServiceSystemApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(SpringStorageServiceSystemApplication.class, args);

        System.out.println("\n--- Container Started ---\n");

        StorageService storageService = context.getBean(StorageService.class);
        storageService.storeFile("data.txt");

        System.out.println("\n--- Getting Local Storage Beans ---\n");

        StorageService local1 =
                context.getBean("localStorage", StorageService.class);

        StorageService local2 =
                context.getBean("localStorage", StorageService.class);

        System.out.println("local1 == local2 : " + (local1 == local2));
    }
}