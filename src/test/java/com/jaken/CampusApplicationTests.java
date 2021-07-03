package com.jaken;

import com.jaken.secondHand.mapper.GoodsMapper;
import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.service.GoodsService;
import com.jaken.secondHand.service.UserService;
import com.jaken.secondHand.service.impl.GoodsServiceImpl;
import com.jaken.secondHand.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class CampusApplicationTests {
    @Autowired
    private GoodsService goodsService;

    @Test
    void contextLoads() {
        List<Goods> goodsLists = goodsService.goodsLists(2);
        for (Goods goodsList : goodsLists) {
            System.out.println(goodsList);
        }
    }


}
