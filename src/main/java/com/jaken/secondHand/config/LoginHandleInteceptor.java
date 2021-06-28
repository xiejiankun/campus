package com.jaken.secondHand.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandleInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userName = request.getSession().getAttribute("userName");
        if(userName==null) {
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;//放行
        }else {
            return true;
        }
    }

}
