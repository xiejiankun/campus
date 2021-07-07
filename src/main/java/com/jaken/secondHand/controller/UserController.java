package com.jaken.secondHand.controller;

import com.jaken.secondHand.config.Md5;
import com.jaken.secondHand.pojo.ShoppingCart;
import com.jaken.secondHand.pojo.User;
import com.jaken.secondHand.service.ShoppingCartService;
import com.jaken.secondHand.service.UserService;
import com.jaken.secondHand.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private Md5 md5 = new Md5();
    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;
/*
    @RequestMapping("/showUserList")
    public List<User> showUserList(){
        List<User> users = userService.showUserList();
        return users;
    }*/

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }


    @PostMapping("/login")
    public String login(String userName, String userPwd, Model model, HttpSession session) {
        Integer userId = userService.login(userName, userPwd);
        System.out.println(userId);
        if (userId!=0) {
            session.setAttribute("userName", userName);
            session.setAttribute("userId",userId);
            System.out.println("登录成功");
            return "index";
        }
        System.out.println("登陆失败===============");
        model.addAttribute("msg", "用户名或密码错误");
        return "login";
    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "redirect:/index.html";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "redirect:/register.html";
    }


    @RequestMapping("/userNameUnique")
    @ResponseBody
    public String userNameUnique(String userName) {
        if (!userService.isUnique(userName)) {
            return "用户名已存在，重新输入用户名！";
        }
        return "";
    }

    @RequestMapping("/register")
    public String register(User user, Model model) {
        Boolean flag;
        flag = userService.addUser(user);
        if (flag) {
            model.addAttribute("msg", "您已成功注册，请登录！");
            shoppingCartService.addShoppingCart(user.getUserId());
            return "login";
        } else {
            model.addAttribute("msg", "注册失败!请重新注册");
            return "register";
        }
    }
}
