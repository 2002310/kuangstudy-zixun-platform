package com.pug.zixun.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pug.zixun.domain.User;
import com.pug.zixun.service.UserService;
import com.pug.zixun.vo.UserVO;
import org.apache.el.lang.ELArithmetic;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import sun.security.ec.ECPublicKeyImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class PassportLoginController {
    final static String key = "TokenKey";
    @Autowired
    RedisTemplate<String, Object> template;
    @Autowired
    private UserService service;
    @PostMapping("/token/login")
    public String tokenLogin(@RequestBody UserVO userVO) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        wrapper.eq("username", userVO.getUserName());
        User user = service.getOne(wrapper);
        System.out.println(user);
        if (!(user.getUsername().equals(userVO.getUserName())&&user.getPassword().equals(userVO.getPassWord()))) {
            throw new RuntimeException("账号密码错误");
        }
        Algorithm algorithm = Algorithm.HMAC256(key);
        String token = JWT.create().withClaim("id", user.getId()).withExpiresAt(new Date(System.currentTimeMillis() + 50000)).sign(algorithm);
        return token;
    }

    @GetMapping("/token/info")
    public User getUser(HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        return user;
    }
}
