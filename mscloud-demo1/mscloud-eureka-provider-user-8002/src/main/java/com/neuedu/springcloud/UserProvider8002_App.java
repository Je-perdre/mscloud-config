package com.neuedu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.neuedu.springcloud.repository") // 扫描数据访问层接口的包名。
@EnableEurekaClient
//本服务启动后会自动注册进eureka服务中  http://localhost:7788/    http://192.168.93.1:8002/actuator/info
@EnableDiscoveryClient //服务发现
public class UserProvider8002_App {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider8002_App.class, args);
    }
}
