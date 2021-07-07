package com.jaken.secondHand.service;

import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.pojo.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
public interface ShoppingCartService extends IService<ShoppingCart> {
    List<Goods> getShoppingCartGoodsByUserId(Integer userId);
    void addShoppingCart(Integer userId);
    List<Goods> getOrderGoodsByOrderId(Integer orderId);

}
