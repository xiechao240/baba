package com.baba.order.service.impl;

import com.baba.order.pojo.Order;
import com.baba.order.service.OrderService;
import com.baba.order.mapper.OrderMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public IPage<Order> queryUserOrderList(Integer pageNum, Integer pageSize, Integer status) {
        IPage<Order> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        // 获取登录用户
//        UserInfo user = LoginInterceptor.getLoginUser();
        String userId = "03e5205e8899fcba680671b900bae271";

        return orderMapper.queryUserOrderList(page, userId, status);
    }
}
