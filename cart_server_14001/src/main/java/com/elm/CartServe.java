package com.elm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.elm.mapper")
public class CartServe {
    public static void main(String[] args) {
        SpringApplication.run(CartServe.class, args);
    }
}

