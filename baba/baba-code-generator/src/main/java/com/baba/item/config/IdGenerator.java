package com.baba.item.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/4/16 16:13
 * @description 未写完，来自：https://mp.baomidou.com/guide/id-generator.html#spring-boot
 */
@Component
public class IdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
        String bizKey = entity.getClass().getName();
        //根据bizKey调用分布式ID生成
//        long id = ....;
        long id = 1;//此处书写自己的id生成策略
        //返回生成的id值即可.
        return id;
    }
}
