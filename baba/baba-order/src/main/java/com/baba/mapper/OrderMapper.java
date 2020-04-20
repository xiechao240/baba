package com.baba.mapper;

import com.baba.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author xiechao
 * @since 2020-04-16
 */
public interface OrderMapper extends BaseMapper<Order> {

    IPage<Order> queryUserOrderList(IPage<Order> page, String userId, Integer status);

}
