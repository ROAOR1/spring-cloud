package com.example.eurekaclient8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class EurekaClient8004Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClient8004Application.class, args);
    }
}
