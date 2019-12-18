package com.example.turbineclient9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class TurbineClient9000Application {
    public static void main(String[] args) {
        SpringApplication.run(TurbineClient9000Application.class, args);
    }
}
