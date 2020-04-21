package com.baba.item.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 *
 * @author xiechao
 * @time 2019年1月8日 下午5:06:50
 * @version 1.0.0
 * @description 自定义公共字段填充处理器MetaObjectHandler，比如逻辑删除字段自动更新删除标志
 */
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisPlusMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");

        Object deleted = getFieldValByName("updateTime", metaObject);
        Object createDateTime = getFieldValByName("createDateTime", metaObject);
        Object updateDateTime = getFieldValByName("updateDateTime", metaObject);

        if(deleted == null){
            this.setFieldValByName("deleted", false, metaObject);//false为未删除，这个填入的值，取决于实体类中定义的类型，比如deleted在pojo类中为boolean类型
        }
        if(createDateTime == null){
            this.setFieldValByName("createDateTime", LocalDateTime.now(), metaObject);//新增记录时，自动补全创建时间与更新时间
        }
        if(updateDateTime == null){
            this.setFieldValByName("updateDateTime", LocalDateTime.now(), metaObject);//新增记录时，自动补全创建时间与更新时间
        }

    }

    /**
     * 下面的修改方法，增加删除标志，其实可以不用，暂时先放着吧
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start update fill ....");

        Object updateDateTime = getFieldValByName("updateDateTime", metaObject);
//        Object updateById = getFieldValByName("updateById", metaObject);

//        setFieldValByName("updateId", ShiroUtil.getUserInfo().getId(), metaObject);//后续再扩充，自动补全用户
//        setFieldValByName("updateName",ShiroUtil.getUserInfo().getName(),metaObject);

        if(updateDateTime == null){
            this.setFieldValByName("updateDateTime", LocalDateTime.now(), metaObject);//修改记录时，自动补全创建时间与更新时间
        }
    }
}
