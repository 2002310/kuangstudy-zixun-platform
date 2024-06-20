package com.pug.zixun.config.mvc;

import com.pug.zixun.config.interceptor.PassportLoginInterceptor;
import com.pug.zixun.config.interceptor.PassportLoginOutInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan(basePackages = "com.pug.zixun")
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private PassportLoginInterceptor passportLoginInterceptor;
    @Autowired
    private PassportLoginOutInterceptor passportLoginOutInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportLoginInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/**/list");
        registry.addInterceptor(passportLoginOutInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/**/list");
    }
}
