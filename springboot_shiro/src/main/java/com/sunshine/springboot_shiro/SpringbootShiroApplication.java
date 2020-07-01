package com.sunshine.springboot_shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//之前是，直接在Mapper类上面添加注解@Mapper，这种方式要求每一个mapper类都需要添加此注解，麻烦
//通过使用@MapperScan可以指定要扫描的Mapper类的包的路径   同时,使用@MapperScan注解多个包
public class SpringbootShiroApplication {

	public static void main(String[] args) {
		System.out.println("SpringBootShiro启动中。。。");
		SpringApplication.run(SpringbootShiroApplication.class, args);
		System.out.println("SpringBootShiro启动完成。。。");
	}

}
