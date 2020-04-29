package com.baba.user.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/4/14 14:48
 * @description
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    //注册分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }


    /**
     * 注册性能分析插件，并格式化sql语句，打印sql执行时间,在最新的3.3.0，以下不支持了，需要使用新的插件p6spy，驱动都要换掉driver-class-name: com.p6spy.engine.spy.P6SpyDriver，先放放吧
     * 原来3.0.6版本，使用下面的没有问题,现在3.3使用下面的报错了
     */
//    @Bean
//    @Profile({"dev","test"})// 设置 dev test 环境开启
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        //格式化sql语句
//        Properties properties = new Properties();
//        properties.setProperty("format", "true"); //参数：format SQL SQL是否格式化，默认false
////        properties.setProperty("maxTime", "100");  //参数：maxTime SQL 执行最大时长，超过自动停止运行，有助于发现问题
//        performanceInterceptor.setProperties(properties);
//        return performanceInterceptor;
//    }

}