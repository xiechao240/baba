package com.baba.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/4/16 15:36
 * @description
 */
@SpringBootApplication
@MapperScan("com.baba.order.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
