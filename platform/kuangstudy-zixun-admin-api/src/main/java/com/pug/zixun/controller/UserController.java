package com.pug.zixun.controller;

import com.pug.zixun.bo.UserBo;
import com.pug.zixun.common.anno.IgnoreToken;
import com.pug.zixun.common.enums.AdminErrorResultEnum;
import com.pug.zixun.config.jwt.JwtServer;
import com.pug.zixun.config.validator.PugAssert;
import com.pug.zixun.domain.User;
import com.pug.zixun.service.UserService;
import com.pug.zixun.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@Slf4j
public class UserController extends BaseController{

    //    @Autowired
//    private UserService service;
//
//    @GetMapping("/user/{id}")
//    public R getUser(@PathVariable("id") Integer id){
//        User byId = service.getById(id);
//        if (byId==null){
//            throw new RuntimeException("用户找不到");
//        }
//        return R.success(AdminSuccessResultEnum.ADMIN_SUCCESS,byId);
//    }
//    @PostMapping("/user/save")
//
//    public User saveUser(@RequestBody UserVO userVO){
//        if (userVO.getUserName()==null) {
//            throw new RuntimeException("用户名为空");
//        }
//        User user = new User();
//        return user;
//    }

    @PostMapping("/user/save")
    public String saveUser() {
        return "成功";
    }


}
