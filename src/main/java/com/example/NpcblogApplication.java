package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class NpcblogApplication {

    public static void main(String[] args) {

        SpringApplication.run(NpcblogApplication.class, args);
        System.out.println("http://localhost:8080");
    }

}
