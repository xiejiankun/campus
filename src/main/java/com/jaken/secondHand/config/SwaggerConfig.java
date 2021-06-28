package com.jaken.secondHand.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("二手商城")
                .enable(true) //配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.jaken.secondHand.controller"))
                // 配置如何通过path过滤,即这里只扫描请求以/kuang开头的接口
                .paths(PathSelectors.any())//扫描该包下的所有路径
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("二手商城接口文档")
                .description("二手商城接口文档")
                .contact(new Contact("jaken", "", "3486975416@qq.com"))
                .version("1.0")
                .build();
    }
}
