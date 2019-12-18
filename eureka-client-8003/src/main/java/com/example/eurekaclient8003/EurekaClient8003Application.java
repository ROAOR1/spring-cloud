package com.example.eurekaclient8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class EurekaClient8003Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClient8003Application.class, args);
    }
}
