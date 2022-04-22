package com.project;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@EnableDubbo
@SpringBootApplication(scanBasePackages = "com")
@MapperScan(basePackages = "com.project.dao.mapper")
@ImportResource("classpath:provider.xml")
public class BookApp {
    public static void main(String[] args) {
        SpringApplication.run(BookApp.class, args);
    }
}
