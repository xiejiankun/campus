package com.jaken.secondHand.service.impl;

import com.jaken.secondHand.pojo.OrderGoods;
import com.jaken.secondHand.mapper.OrderGoodsMapper;
import com.jaken.secondHand.service.OrderGoodsService;
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
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsMapper, OrderGoods> implements OrderGoodsService {
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Override
    public void addOrderGoods(int orderId, List<Integer> goodsIdList) {
        for (Integer goodsId : goodsIdList) {
            orderGoodsMapper.insert(new OrderGoods(orderId,goodsId,1));
        }
    }
}
