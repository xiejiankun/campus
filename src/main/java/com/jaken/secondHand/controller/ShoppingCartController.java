package com.jaken.secondHand.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/shoppingCartGoods/{userId}")
    public String getshoppingCartGoods(@PathVariable int userId, Model model){
        List<Goods> goodsList = shoppingCartService.getShoppingCartGoodsByUserId(userId);
        System.out.println("===================");
        model.addAttribute("list",goodsList);
        return "shoppingcart";
    }
    @RequestMapping("/getOrderGoodsByOrderId/{orderId}")
    public String getOrderGoodsByOrderId(@PathVariable int orderId,Model model) {
        List<Goods> orderGoodsByOrderId = shoppingCartService.getOrderGoodsByOrderId(orderId);
        model.addAttribute("list",orderGoodsByOrderId);
        return "OrderGoods";
    }

}

