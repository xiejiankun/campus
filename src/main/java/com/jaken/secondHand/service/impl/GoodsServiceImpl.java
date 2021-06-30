package com.jaken.secondHand.service.impl;

import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.mapper.GoodsMapper;
import com.jaken.secondHand.service.GoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> goodsLists() {
        List<Goods> goods = goodsMapper.selectList(null);
        return goods;
    }
}
