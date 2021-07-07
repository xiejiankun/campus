package com.jaken.secondHand.controller;


import com.jaken.secondHand.pojo.scOrder;
import com.jaken.secondHand.service.OrderGoodsService;
import com.jaken.secondHand.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderGoodsService orderGoodsService;
    @RequestMapping("/toMyOrder/{userId}")
    public String toMyOrder(@PathVariable int userId, Model model) {
        List<scOrder> scOrders = orderService.showOrderList(userId);
        model.addAttribute("list",scOrders);
        return "myOrder";
    }

    @ResponseBody
    @RequestMapping("addOrder/{userId}/{totalMoney}")
    public String addOrder(@PathVariable int userId,@PathVariable double totalMoney,String goodsIdList) {
        int orderId = orderService.addOrder(userId, totalMoney);
        System.out.println(goodsIdList);
        String[] split = goodsIdList.split(",");
/*        Integer[] list = new Integer[split.length];*/
        List <Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        System.out.println(list);
        orderGoodsService.addOrderGoods(orderId,list);
        return "您的订单已生成！请在我的订单中查看！";
    }

    @RequestMapping("addOrder/{userId}/{totalMoney}/{goodsId}")
    public String addOrder(@PathVariable int userId,@PathVariable double totalMoney,@PathVariable int goodsId) {
        int orderId = orderService.addOrder(userId, totalMoney);

        List <Integer> list = new ArrayList<>();
        list.add(goodsId);
        System.out.println(list);
        orderGoodsService.addOrderGoods(orderId,list);
        return "redirect:/toMyOrder/"+userId;
    }
}

