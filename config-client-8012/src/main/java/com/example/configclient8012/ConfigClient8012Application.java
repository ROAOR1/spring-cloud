package com.example.configclient8012;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConfigClient8012Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient8012Application.class, args);
    }
}
