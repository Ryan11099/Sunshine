package com.sunshine.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Slf4j
@SpringBootApplication
@MapperScan("com.sunshine.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("项目启动。。。");
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("启动完成。。。");
    }

}
