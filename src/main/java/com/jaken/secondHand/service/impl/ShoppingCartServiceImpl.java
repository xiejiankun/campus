package com.jaken.secondHand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.pojo.ShoppingCart;
import com.jaken.secondHand.mapper.ShoppingCartMapper;
import com.jaken.secondHand.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public List<Goods> getShoppingCartGoodsByUserId(Integer userId) {
        List<Goods> goods = shoppingCartMapper.getShoppingCartGoodsByUserId(userId);
        return goods;
    }

    @Override
    public void addShoppingCart(Integer userId) {
        shoppingCartMapper.addShoppingCart(userId);
    }

    @Override
    public List<Goods> getOrderGoodsByOrderId(Integer orderId) {
        List<Goods> orderGoods = shoppingCartMapper.getOrderGoodsByOrderId(orderId);
        return orderGoods;

    }

}
