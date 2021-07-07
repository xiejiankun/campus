package com.jaken;

import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.pojo.OrderGoods;
import com.jaken.secondHand.pojo.scOrder;
import com.jaken.secondHand.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class CampusApplicationTests {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private GoodsCartService goodsCartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderGoodsService orderGoodsService;

    @Test
    void contextLoads() {
        Map<String, Object> map = goodsService.goodsLists(2);
        System.out.println(map);
    }
    @Test
    void getGoodsByName(){
        Map<String, Object> map = goodsService.getGoodsByName(1,"书");
        System.out.println(map);
    }
    @Test
    void shoppingCartGoods(){
        Goods goods = goodsService.showGoodsDetial(27);
        System.out.println(goods);
    }
    @Test
    void deleteGoodsFromCart() {
        goodsCartService.deleteShoppingCartGoods(1,1);
    }
    @Test
    void getOrders() {
        List<scOrder> scOrders = orderService.showOrderList(1);
        System.out.println(scOrders);
    }
    @Test
    void addOrderGoods() {
        Integer [] a={1,5,3};
        List<Integer> aList=Arrays.asList(a);
        orderGoodsService.addOrderGoods(2,aList);
    }
    @Test
    void addOrder() {
        orderService.addOrder(1,10);
    }
    @Test
    void updateGoods() {
        Goods goods = new Goods();
        goods.setGoodsId(36);
        goods.setGoodsName("hehe");
        goods.setGoodsDesc("niubi");
        goods.setGoodsBrand("hua");
        goods.setGoodsPrice(20.0);
        goodsService.updateGoods(goods);
    }

}
