package com.jaken.secondHand.service;

import com.jaken.secondHand.pojo.GoodsCart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
public interface GoodsCartService extends IService<GoodsCart> {
    int addGoodsToShoppingCart(Integer goodsId,Integer userId);
    int deleteShoppingCartGoods(Integer goodsId,Integer userId);
}
