package com.baba.service.impl;

import com.baba.pojo.OrderStatus;
import com.baba.mapper.OrderStatusMapper;
import com.baba.service.OrderStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单状态表 服务实现类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-16
 */
@Service
public class OrderStatusServiceImpl extends ServiceImpl<OrderStatusMapper, OrderStatus> implements OrderStatusService {

}
