package com.jiepi.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka8300Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8300Application.class, args);
    }

}
