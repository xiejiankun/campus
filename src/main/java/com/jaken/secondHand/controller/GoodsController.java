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
    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/getAllGoods")
    @ResponseBody
    public String showGoods(int currentPage) throws JsonProcessingException {
        List<Goods> goods = goodsService.goodsLists(currentPage);
        String str = mapper.writeValueAsString(goods);
        return str;
    }

    @RequestMapping("/getTotalPage")
    @ResponseBody
    public Integer getTotalPage() throws JsonProcessingException {
        return goodsService.getTotalPage();
    }

}

