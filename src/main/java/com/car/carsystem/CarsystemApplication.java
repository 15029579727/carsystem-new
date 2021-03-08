package com.car.carsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "com.car.carsystem.dao")
public class CarsystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarsystemApplication.class, args);
    }
}