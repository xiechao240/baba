package com.baba.service.impl;

import com.baba.pojo.User;
import com.baba.mapper.UserMapper;
import com.baba.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表，所有登录CRM系统的员工账号都存储在此表 服务实现类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
