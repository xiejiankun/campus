package com.jaken.secondHand.controller;


import com.jaken.secondHand.service.GoodsCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Controller
public class GoodsCartController {

    @Autowired
    private GoodsCartService goodsCartService;


    @RequestMapping("/addGoodsToShoppingCart/{goodsId}/{userId}")
    private String addGoodsToShoppingCart(@PathVariable int goodsId, @PathVariable Integer userId, Model model) {
        int res = goodsCartService.addGoodsToShoppingCart(goodsId, userId);
        if (res==1) model.addAttribute("msg","添加物品成功！QWQ");
        else model.addAttribute("msg","您的购物车中已经存在这个商品了哦！QWQ");
        return "index";
    }

    @RequestMapping("/deleteShoppingCartGoods/{goodsId}/{userId}")
    private String deleteShoppingCartGoods(@PathVariable int goodsId, @PathVariable Integer userId) {
        goodsCartService.deleteShoppingCartGoods(goodsId, userId);
        return "redirect:/shoppingCartGoods/"+userId;
    }

}

