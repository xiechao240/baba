package com.baba.service.impl;

import com.baba.pojo.OrderDetail;
import com.baba.mapper.OrderDetailMapper;
import com.baba.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-16
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
