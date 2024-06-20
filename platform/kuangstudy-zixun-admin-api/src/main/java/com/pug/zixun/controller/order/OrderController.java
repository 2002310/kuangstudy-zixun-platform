package com.pug.zixun.controller.order;

import com.pug.zixun.common.anno.IgnoreToken;
import com.pug.zixun.controller.base.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@IgnoreToken
public class OrderController extends BaseController {
    @PostMapping("/order/save")
    public String makeOrder() {
        return "success";
    }
    @PostMapping("/order/to")

    public String makeTo() {
        return "success";
    }

}
