package com.jaken.secondHand.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.pojo.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */

@Repository
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
    void addShoppingCart(int userId);
    List<Goods> getShoppingCartGoodsByUserId(@Param("userId") Integer userId);
    List<Goods> getOrderGoodsByOrderId(@Param("orderId") Integer orderId);
}

