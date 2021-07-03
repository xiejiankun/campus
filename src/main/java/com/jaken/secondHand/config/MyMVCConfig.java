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
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInteceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/toLogin","/toRegister","/login","/register",
                        "/userNameUnique","/getTotalPage","/getAllGoods",
                "/css/**","/fonts/**",
                "/**/**","/img/**"
        );
    }
}
