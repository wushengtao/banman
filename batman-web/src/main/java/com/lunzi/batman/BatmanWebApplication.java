package com.lunzi.batman;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lunzi.batman.dal.dao")
@ComponentScan(basePackages = { "com.lunzi.batman","com.lunzi.batman","com.lunzi.batman"})
public class BatmanWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatmanWebApplication.class, args);
    }

}
