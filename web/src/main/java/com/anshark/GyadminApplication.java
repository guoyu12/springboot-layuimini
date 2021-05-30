package com.anshark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan(basePackages = {"com.anshark.mapper"})
@Controller
public class GyadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GyadminApplication.class, args);
    }

    @RequestMapping("/")
    String home(){
        return "/login/page";
    }

}
