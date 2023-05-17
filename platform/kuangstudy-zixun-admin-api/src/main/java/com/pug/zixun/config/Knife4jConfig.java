package com.pug.zixun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("默认的api文档")
                        .description("学相伴咨询点播系统")
                        .license("http://www.baidu.com")
                        .version("1.0")
                        .contact("xueci@qq.com").build())
                .groupName("2.x")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pug.zixun.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
