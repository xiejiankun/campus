package com.jaken.secondHand.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaken.secondHand.pojo.Goods;
import com.jaken.secondHand.service.GoodsService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        Map<String, Object> map = goodsService.goodsLists(currentPage);
        String str = mapper.writeValueAsString(map);
        return str;
    }

    @RequestMapping("/toMySell")
    public String toMySell(){
        return "redirect:mySell.html";
    }
    @RequestMapping("/toSellGoods")
    public String toSellGoods() {
        return "sellGoods";
    }

    @RequestMapping("/goodsDetial/{goodsId}")
    public String toGoodsDetial(@PathVariable int goodsId,Model model){
        Goods goods = goodsService.showGoodsDetial(goodsId);
        model.addAttribute("goods",goods);
        System.out.println("=========="+goods);
        return "goodsDetial";
    }

    @RequestMapping("/getGoodsByName")
    @ResponseBody
    public String getGoodsByName(int currentPage,String goodsName) throws JsonProcessingException {
        Map<String, Object> map = goodsService.getGoodsByName(currentPage, goodsName);
        String str = mapper.writeValueAsString(map);
        return str;
    }


    @PostMapping("/sellGoods/{userId}")
    public String addGoods(@RequestParam("file") MultipartFile file,@PathVariable int userId,Goods goods,Model model) {
        System.out.println("==============="+goods);
        if(file.isEmpty()) {
            model.addAttribute("msg","上传失败");
            return "sellGoods";
        }
        String filename = file.getOriginalFilename();
        String filePath = "D:\\Java_project\\campus\\src\\main\\resources\\static\\img\\";
        File dest = new File(filePath + filename);

        try {
            file.transferTo(dest);
            System.out.println("上传成功");
            goods.setUserId(userId);
            goods.setMainImg(filename);
            int i = goodsService.addGoods(goods);
            if(i==1) {
                model.addAttribute("msg","上传成功!");
            }else{
                model.addAttribute("msg","上传失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
            model.addAttribute("msg","上传失败");
        }
        return "sellGoods";
    }

    @RequestMapping("/toMySell/{userId}")
    public String toMySell(@PathVariable int userId,Model model) {
        List<Goods> goods = goodsService.showMyGoods(userId);
        model.addAttribute("list",goods);
        return "mySell";
    }

    @RequestMapping("/deleteMyGoods/{goodsId}")
    public String deleteMyGoods(@PathVariable int goodsId) {
        int userId = goodsService.deleteMyGoods(goodsId);
        return "redirect:/toMySell/"+userId;
    }

    @RequestMapping("/toUpdateGoods/{goodsId}")
    public String toUpdateGoods(@PathVariable int goodsId,Model model) {
        Goods goods = goodsService.showGoodsDetial(goodsId);
        System.out.println(goods);
        model.addAttribute("goods",goods);
        return "updateGoods";
    }

    @RequestMapping("/updateGoods/{goodsId}/{userId}")
    public String updateGoods(@PathVariable int goodsId,@PathVariable int userId, Goods goods) {
        goods.setGoodsId(goodsId);
        goodsService.updateGoods(goods);
        return "redirect:/toMySell/"+userId;
    }
}

