package com.pug.zixun.controller;

import com.pug.zixun.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RedisController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @PostMapping("/redis/set")
    public String set(@RequestBody UserVO userVO){
        redisTemplate.opsForValue().set("uservo",userVO);
        return "success";
    }
    @GetMapping("/redis/get")
    public UserVO get(){
        return (UserVO) redisTemplate.opsForValue().get("uservo");

    }

}
