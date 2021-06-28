package com.jaken.secondHand.controller;

import com.jaken.secondHand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


/*    @RequestMapping("/showUserList")
    public List<User> showUserList(){
        List<User> users = userService.showUserList();
        return users;
    }*/

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @PostMapping("/login")
    public String login(String userName, String userPwd, Model model) {
        System.out.println("============");
        System.out.println(userName);
        System.out.println(userPwd);
        Boolean flag = userService.login(userName, userPwd);
        System.out.println("==================="+flag);
        if(flag) {
            return "success";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "login";
    }
}
