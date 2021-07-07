package com.jaken.secondHand.service;

import com.jaken.secondHand.pojo.OrderGoods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
public interface OrderGoodsService extends IService<OrderGoods> {
    void addOrderGoods(int orderId, List<Integer> goodsIdList);

}
