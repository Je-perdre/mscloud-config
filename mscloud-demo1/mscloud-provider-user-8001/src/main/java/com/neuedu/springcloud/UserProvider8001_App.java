package com.neuedu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// 扫描数据访问层接口的包名。
@MapperScan("com.neuedu.springcloud.repository")
public class UserProvider8001_App {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider8001_App.class, args);
    }
}
