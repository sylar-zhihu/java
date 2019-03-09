package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 主程序入口 注解
@SpringBootApplication
public class DemotApplication {

    public static void main(String[] args) {
        // 启动方法 传入启动类的.class
        SpringApplication.run(DemotApplication.class, args);
    }
}
