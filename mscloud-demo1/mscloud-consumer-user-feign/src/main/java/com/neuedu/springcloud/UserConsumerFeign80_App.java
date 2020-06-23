package com.neuedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserConsumerFeign80_App {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerFeign80_App.class, args);
    }

}