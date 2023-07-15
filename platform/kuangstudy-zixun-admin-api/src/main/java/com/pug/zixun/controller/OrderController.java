package com.pug.zixun.controller;

import com.pug.zixun.common.anno.IgnoreToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController extends BaseController{
    @PostMapping("/order/save")
    public String makeOrder() {
        return "success";
    }
    @PostMapping("/order/to")
    @IgnoreToken
    public String makeTo() {
        return "success";
    }

}
