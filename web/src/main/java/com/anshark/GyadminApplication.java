package com.anshark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.anshark.mapper"})
public class GyadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GyadminApplication.class, args);
    }

}
