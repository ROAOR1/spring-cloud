package com.example.configclient8011;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConfigClient8011Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient8011Application.class, args);
    }
}
