package com.jaken.secondHand.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/getAllGoods")
    @ResponseBody
    public List<Goods> showGoods(int currentPage) throws JsonProcessingException {
        List<Goods> goods = goodsService.goodsLists(currentPage);
//        ObjectMapper mapper= new ObjectMapper();
//        String str = mapper.writeValueAsString(goods);
        return goods;
    }

    @RequestMapping("/getTotalPage")
    @ResponseBody
    public Integer getTotalPage() {
        return goodsService.getTotalPage();
    }

}

