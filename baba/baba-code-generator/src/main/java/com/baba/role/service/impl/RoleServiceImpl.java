package com.baba.role.service.impl;

import com.baba.role.pojo.Role;
import com.baba.role.mapper.RoleMapper;
import com.baba.role.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
