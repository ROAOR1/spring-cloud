package com.example.eurekaserver8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer8002Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer8002Application.class, args);
    }

}
