package com.pug.zixun.controller;

import com.pug.zixun.common.enums.AdminErrorResultEnum;
import com.pug.zixun.common.enums.AdminSuccessResultEnum;
import com.pug.zixun.common.result.R;
import com.pug.zixun.domain.User;
import com.pug.zixun.service.UserService;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Slf4j
public class UserController {
    @Autowired
    private UserService service;
//    @ApiOperation("一个普通的get请求")
    @GetMapping("/user/{id}")
    public R getUser(@PathVariable Integer id){
        User byId = service.getById(id);
        if (byId==null){
            throw new RuntimeException("用户找不到");
        }
        return R.success(AdminSuccessResultEnum.ADMIN_SUCCESS,byId);
    }
}
