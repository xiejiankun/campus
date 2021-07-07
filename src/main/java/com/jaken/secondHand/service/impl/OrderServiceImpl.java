package com.jaken.secondHand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jaken.secondHand.pojo.scOrder;
import com.jaken.secondHand.mapper.OrderMapper;
import com.jaken.secondHand.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, scOrder> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<scOrder> showOrderList(int userId) {
        QueryWrapper<scOrder> wrapper = new QueryWrapper<>();
        wrapper
                .select("order_id","user_id","status","order_time","pay_time","total_money")
                .eq("user_id",userId)
                .orderByDesc("order_time");
        List<scOrder> scOrders = orderMapper.selectList(wrapper);
        return scOrders;
    }

    @Override
    public int addOrder(int userId, double totalMoney) {
        scOrder order = new scOrder();
        order.setUserId(userId);
        order.setTotalMoney(totalMoney);
        orderMapper.insert(order);
        QueryWrapper<scOrder> wrapper = new QueryWrapper<>();
        wrapper
                .select("order_id","user_id","status","order_time","pay_time","total_money");
        List<scOrder> scOrders = orderMapper.selectList(wrapper);
        Integer orderId = scOrders.get(scOrders.size() - 1).getOrderId();
        return orderId;
    }
}
