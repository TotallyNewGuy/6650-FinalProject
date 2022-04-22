package com.project;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@EnableDubbo
@ImportResource("classpath:provider.xml")
@SpringBootApplication
public class PurchaseApp {
    public static void main(String[] args) {
        SpringApplication.run(PurchaseApp.class, args);
    }
}
