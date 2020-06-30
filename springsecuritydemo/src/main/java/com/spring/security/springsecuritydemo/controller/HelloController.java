package com.spring.security.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanjh
 * @date 2020/6/30 20:37
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // 配置该地址不需要登录
    @GetMapping("/vercode")
    public String vercode() {
        return "vercode";
    }
}
