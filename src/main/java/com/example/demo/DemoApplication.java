package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan({"com.example.demo.area.mapper","com.example.demo.godown.mapper",
              "com.example.demo.outdown.mapper","com.example.demo.inventory.mapper",
                "com.example.demo.user.mapper","com.example.demo.login.mapper",
        "com.example.demo.menu.mapper","com.example.demo.role.mapper"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
