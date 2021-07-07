package com.jaken.secondHand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jaken.secondHand.pojo.GoodsCart;
import com.jaken.secondHand.mapper.GoodsCartMapper;
import com.jaken.secondHand.service.GoodsCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jaken.secondHand.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GoodsCartServiceImpl extends ServiceImpl<GoodsCartMapper, GoodsCart> implements GoodsCartService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;
    @Override
    public int addGoodsToShoppingCart(Integer goodsId, Integer userId) {
        int res = goodsCartMapper.addGoodsCart(new GoodsCart(userId, goodsId));
        return res;
    }

    @Override
    public int deleteShoppingCartGoods(Integer goodsId, Integer userId) {
        QueryWrapper <GoodsCart> wrapper = new QueryWrapper<>();
        wrapper
                .eq("goods_id",goodsId)
                .eq("cart_id",userId);
        int res = goodsCartMapper.delete(wrapper);
        return res;
    }
}
