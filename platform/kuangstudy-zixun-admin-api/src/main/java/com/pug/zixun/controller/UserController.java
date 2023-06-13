package com.pug.zixun.controller;

import com.pug.zixun.common.enums.AdminSuccessResultEnum;
import com.pug.zixun.common.result.R;
import com.pug.zixun.domain.User;
import com.pug.zixun.service.UserService;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
import com.pug.zixun.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
//@Slf4j
public class UserController {
    @Autowired
    private UserService service;
    @ApiOperation("一个普通的get请求")
    @GetMapping("/user/{id}")
    public R getUser(@PathVariable("id") Integer id){
        User byId = service.getById(id);
        if (byId==null){
            throw new RuntimeException("用户找不到");
        }
        return R.success(AdminSuccessResultEnum.ADMIN_SUCCESS,byId);
    }
    @PostMapping("/user/save")
    @ApiOperation("保存用户")
    public User saveUser(@RequestBody UserVO userVO){
        if (userVO.getUserName()==null) {
            throw new RuntimeException("用户名为空");
        }
        User user = new User();
        return user;
    }
}
