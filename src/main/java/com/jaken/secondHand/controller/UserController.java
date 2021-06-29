package com.jaken.secondHand.controller;

import com.jaken.secondHand.pojo.User;
import com.jaken.secondHand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

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
        Boolean flag = userService.login(userName, userPwd);
        if(flag) {
            session.setAttribute("userName",userName);
            System.out.println("session============");
            return "success";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "login";
    }
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }
    @RequestMapping("/register")
    public String register(User user,Model model){
        Boolean flag=false;
        flag=userService.isUnique(user.getUserName());
        if (!flag) {
            model.addAttribute("msg","用户名已存在，重新输入用户名！");
            return "register";
        }
        flag = userService.addUser(user);
        if(flag) {
            model.addAttribute("msg","您已成功注册，请登录！");
            return "login";
        } else {
            model.addAttribute("msg","注册失败!请重新注册");
            return "register";
        }
    }
}
