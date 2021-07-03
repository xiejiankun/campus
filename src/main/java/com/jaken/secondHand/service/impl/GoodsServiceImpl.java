package com.jaken.secondHand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.mapper.GoodsMapper;
import com.jaken.secondHand.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    private final int PAGE_SIZE =10;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public  List<Goods> goodsLists(int currentPage) {
        Page<Goods> goodsPage = new Page<>(currentPage,PAGE_SIZE);
        List<Goods> goods = goodsMapper.showGoodsList(goodsPage);
        for (Goods good : goods) {
            System.out.println(good);
        }
        return goods;
    }

    @Override
    public Integer getTotalPage() {
        Integer count = goodsMapper.selectCount(null);
        if(count%PAGE_SIZE==0) return count/PAGE_SIZE;
        return count/PAGE_SIZE+1;
    }
}
