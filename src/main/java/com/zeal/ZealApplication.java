package com.zeal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.zeal.dao")
public class ZealApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZealApplication.class, args);
    }

}
