package com.baba.item.service.impl;

import com.baba.item.pojo.Order;
import com.baba.item.mapper.OrderMapper;
import com.baba.item.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
