package com.example.feignclient8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignClient8006Application {
    public static void main(String[] args) {
        SpringApplication.run(FeignClient8006Application.class, args);
    }
}
