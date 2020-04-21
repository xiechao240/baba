package com.baba.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Admin
 * @date 2020/4/11 17:08
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启EurekaClient功能
//@EnableHystrix //开启熔断,因为feign里面已经集成熔断器了，所以无需再次引入 feign:hystrix:enabled: true 开启Feign的熔断功能,这个需要配置，因为默认是false不开启的
@EnableFeignClients //开启feign功能
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
