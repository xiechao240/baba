package com.baba.service.impl;

import com.baba.mapper.UserMapper;
import com.baba.pojo.User;
import com.baba.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表，所有登录CRM系统的员工账号都存储在此表 服务实现类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByIdFromXmlReturnBaseResultMap(String userId) {
        return userMapper.queryUserByIdFromXmlReturnBaseResultMap(userId);
    }

    @Override
    public List<HashMap<Object, Object>> queryUserByIdFromXmlReturnHashMap(String userId) {
        return userMapper.queryUserByIdFromXmlReturnHashMap(userId);
    }

    @Override
    public IPage<User> queryUserList(Integer pageNum, Integer pageSize) {
        IPage<User> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        // 判断客户名称是否为空
//        if (loginNameOrUserName != null && !loginNameOrUserName.trim().equals("")) {
//            queryWrapper.like("user_name", loginNameOrUserName).or().like("login_name", loginNameOrUserName);
//        }
//        if (state != null && !state.trim().equals("")) {
//            queryWrapper.eq("state", state);
//        }
//		queryWrapper.orderByDesc("create_time");
        return userMapper.selectPage(page, queryWrapper);
    }


    @Override
    public IPage<User> queryUserListFromXmlSql(Integer pageNum, Integer pageSize, String userType) {
        IPage<User> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        //注意，使用mybatis plus的这种xml文件中sql自动分页的写法，第一个参数，必需为page参数
        return userMapper.queryUserListFromXmlSql(page, userType, null);
    }

//    @Override
//    public IPage<User> queryUserListFromXmlParamMapPageSql(Integer pageNum, Integer pageSize, Map<Object, Object> paramMap) {
//        IPage<User> page = new Page<>();
//        page.setCurrent(pageNum);
//        page.setSize(pageSize);
//
//        return userMapper.queryUserListFromXmlParamMapPageSql(page, paramMap); mybatis plus不支持既传page对象，又传paramMap这种方式
//    }
}
