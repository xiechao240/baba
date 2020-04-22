package com.baba.user.service;

import com.baba.user.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户表，所有登录CRM系统的员工账号都存储在此表 服务类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-14O
 */
public interface UserService extends IService<User> {

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

    public IPage<User> queryUserList(Integer pageNum, Integer pageSize);

    /**
     * 演示传递单个参数形式（注意xml文件中都没有定义parameterType="String" <select id="queryUserListFromXmlSql" resultType="com.baba.pojo.User">）
     * @param pageNum
     * @param pageSize
     * @param userType
     * @return
     */
    IPage<User> queryUserListFromXmlSql(Integer pageNum, Integer pageSize, String userType);

//    /**
//     * 演示参数map传参形式，mybatis plus不支持既传page对象，又传paramMap这种方式
//     * @param pageNum
//     * @param pageSize
//     * @param paramMap
//     * @return
//     */
//    @Deprecated
//    IPage<User> queryUserListFromXmlParamMapPageSql(Integer pageNum, Integer pageSize, Map<Object, Object> paramMap);


}
