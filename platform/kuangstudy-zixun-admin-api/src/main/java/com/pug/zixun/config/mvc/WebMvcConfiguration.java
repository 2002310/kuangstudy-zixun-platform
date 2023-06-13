package com.pug.zixun.config.mvc;

import com.pug.zixun.config.interceptor.OpenFlagHandlerInterceptor;
import com.pug.zixun.config.interceptor.TokenHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan(basePackages = "com.pug.zixun")
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    OpenFlagHandlerInterceptor openFlagHandlerInterceptor;
    @Autowired
    TokenHandlerInterceptor tokenHandlerInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(openFlagHandlerInterceptor).addPathPatterns("/user/**");
        registry.addInterceptor(tokenHandlerInterceptor).addPathPatterns("/user/**").excludePathPatterns("/user//token/login");
    }
}
