package com.spring.security.springsecuritydemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringsecuritydemoApplication {

    public static void main(String[] args) {
        log.info("项目启动。。。");
        SpringApplication.run(SpringsecuritydemoApplication.class, args);
        log.info("项目启动完成。。。");
    }

}
