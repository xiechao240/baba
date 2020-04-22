package com.baba.user.mapper;

import com.baba.user.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户表，所有登录CRM系统的员工账号都存储在此表 Mapper 接口
 * </p>
 *
 * @author xiechao
 * @since 2020-04-14
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     *  从xml文件中读取自定义sql查询用户
     * @param userId 用户ID
     * @return
     */
    public User queryUserByIdFromXmlReturnBaseResultMap(String userId);

    /**
     * 从xml文件中读取自定义sql查询用户
     * @param userId 用户ID
     * @return
     */
    public List<HashMap<Object, Object>> queryUserByIdFromXmlReturnHashMap(String userId);

    /**
     *
     * @param page
     * @param userType
     * @param dataScope 演示不传此参数的时候，直接传入一个null，以支持多种条件查询
     * @return
     */
    IPage<User> queryUserListFromXmlSql(IPage<User> page, String userType, String dataScope);

//    @Deprecated 不支持这种写法，mybatis plus不支持既传page对象，又传paramMap这种方式
//    IPage<User> queryUserListFromXmlParamMapPageSql(IPage<User> page, Map<Object, Object> paramMap);

}
