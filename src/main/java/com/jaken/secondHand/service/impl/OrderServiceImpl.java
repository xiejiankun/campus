package com.jaken.secondHand.service.impl;

import com.jaken.secondHand.pojo.Order;
import com.jaken.secondHand.mapper.OrderMapper;
import com.jaken.secondHand.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
