package com.jaken.secondHand.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/sellGoods.html").setViewName("sellGoods");
        registry.addViewController("myOrder.html").setViewName("myOrder");
        registry.addViewController("mySell.html").setViewName("mySell");
        registry.addViewController("shoppingcart.html").setViewName("shoppingcart");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInteceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/register","/toLogin",
                        "/userNameUnique","/getTotalPage","/getAllGoods",
                        "/toRegister","/register.html",
                        "/css/**","/fonts/**","/getGoodsByName",
                        "/js/**","/img/**"
        );
    }
}
