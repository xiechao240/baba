package com.baba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/4/22 11:35
 * @description
 */
@EnableDiscoveryClient
@EnableZuulProxy // 开启Zuul的网关功能
@SpringBootApplication
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}
