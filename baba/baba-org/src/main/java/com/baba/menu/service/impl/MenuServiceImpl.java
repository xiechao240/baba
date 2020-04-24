package com.baba.menu.service.impl;

import com.baba.menu.mapper.MenuMapper;
import com.baba.menu.pojo.Menu;
import com.baba.menu.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
