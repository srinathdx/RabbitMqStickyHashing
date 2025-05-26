package com.sr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        System.setProperty("node-id", "node1");
        System.out.println("Starting RabbitMQ Service on Node: " + System.getenv("node-id"));
        SpringApplication.run(MainApplication.class, args);
    }
}
