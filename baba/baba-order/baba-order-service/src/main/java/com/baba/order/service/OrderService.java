package com.baba.order.service;

import com.baba.item.pojo.Order;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-16
 */
public interface OrderService extends IService<Order> {

    IPage<Order> queryUserOrderList(Integer pageNum, Integer pageSize, Integer status);

}
