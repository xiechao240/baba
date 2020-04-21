package com.baba.item.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/4/20 16:49
 * @description 通过`logging.level.xx=debug`来设置日志级别。然而这个对Fegin客户端而言不会产生效果。
 *              因为@FeignClient注解修改的客户端在被代理时，都会创建一个新的Fegin.Logger实例。我们需要额外指定这个日志的级别才可以。
 *              1）设置com.leyou包下的日志级别都为debug  2)编写配置类，定义日志级别@Configuration public class FeignConfig {}
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
//        - 支持以下4种级别日志记录
//                - NONE：不记录任何日志信息，这是默认值。
//                - BASIC：仅记录请求的方法，URL以及响应状态码和执行时间
//                - HEADERS：在BASIC的基础上，额外记录了请求和响应的头信息
//                - FULL：记录所有请求和响应的明细，包括头信息、请求体、元数据。
        return Logger.Level.FULL;
    }
}
