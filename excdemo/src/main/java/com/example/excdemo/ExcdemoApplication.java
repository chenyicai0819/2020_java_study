package com.example.excdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.excdemo,mapper")
public class ExcdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcdemoApplication.class, args);
	}

}
