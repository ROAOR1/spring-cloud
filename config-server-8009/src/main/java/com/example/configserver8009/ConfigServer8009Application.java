package com.example.configserver8009;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServer8009Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer8009Application.class, args);
    }
}
