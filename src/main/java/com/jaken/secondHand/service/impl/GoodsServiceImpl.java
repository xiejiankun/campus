package com.jaken.secondHand.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.mapper.GoodsMapper;
import com.jaken.secondHand.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    private final int PAGE_SIZE =10;
    @Autowired
    private GoodsMapper goodsMapper;
    private long getTotalPage(long length) {
        if(length%PAGE_SIZE==0) return length/PAGE_SIZE;
        return length/PAGE_SIZE+1;
    }
    @Override
    public Map<String,Object> goodsLists(int currentPage) {
        Page<Goods> page = new Page<>(currentPage,PAGE_SIZE);
        List<Goods> goods = goodsMapper.showGoodsList(page);
        Map<String, Object> map = new HashMap<>();
        long totalPage=getTotalPage(page.getTotal());
        System.out.println("======total"+page.getTotal());
        map.put("list",goods);
        map.put("totalPage",totalPage);
        return map;

    }

    @Override
    public Map<String,Object> getGoodsByName(int currentPage,String goodsName) {
        Page<Goods> page = new Page<>(currentPage,PAGE_SIZE);
        List<Goods> goods = goodsMapper.showGoodsListByName(page, goodsName);
        Map<String, Object> map = new HashMap<>();
        long totalPage=getTotalPage(page.getTotal());
        map.put("list",goods);
        map.put("totalPage",totalPage);
        return map;
    }

    @Override
    public Goods showGoodsDetial(int goodsId) {
        Goods goods = goodsMapper.showGoodsDetial(goodsId);
        return goods;
    }

    @Override
    public int addGoods(Goods goods) {
        int insert = goodsMapper.insert(goods);
        return insert;
    }

    @Override
    public List<Goods> showMyGoods(int userId) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper
                .select("goods_id","user_id","goods_name","goods_desc","main_img","goods_brand","goods_price")
                .eq("user_id",userId);
        List<Goods> goods = goodsMapper.selectList(wrapper);
        return goods;
    }

    @Override
    public int deleteMyGoods(int goodsId) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.select("user_id")
                .eq("goods_id",goodsId);
        Goods goods = goodsMapper.selectOne(wrapper);
        goodsMapper.deleteById(goodsId);
        return goods.getUserId();
    }

    @Override
    public int updateGoods(Goods goods) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id",goods.getGoodsId());
        int i = goodsMapper.update(goods, wrapper);
        return i;
    }
}
