package com.baba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Admin
 * @date 2020/4/11 17:08
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启EurekaClient功能
@EnableHystrix //开启熔断
@EnableFeignClients //开启feign功能
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
