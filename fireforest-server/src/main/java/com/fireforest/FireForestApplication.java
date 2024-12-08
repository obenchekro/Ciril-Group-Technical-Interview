package com.fireforest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FireForestApplication {
    public static void main(String[] args) {
        SpringApplication.run(FireForestApplication.class, args);
    }
}