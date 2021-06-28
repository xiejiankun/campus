package com.jaken.secondHand.controller;

import com.jaken.secondHand.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
        return "redirect:/login.html";
    }
    @PostMapping("/login")
    public String login(String userName, String userPwd, Model model, HttpSession session) {
/*        System.out.println("============");
        System.out.println(userName);
        System.out.println(userPwd);*/
        Boolean flag = userService.login(userName, userPwd);
        if(flag) {
            session.setAttribute("userName",userName);
            return "redirect:/success.html";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "login";
    }
}
