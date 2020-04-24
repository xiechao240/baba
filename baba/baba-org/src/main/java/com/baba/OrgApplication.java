package com.baba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/4/24 14:53
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.baba.*")
public class OrgApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrgApplication.class, args);
    }
}
