package com.pug.zixun.controller.login;

import com.pug.zixun.bo.UserBo;
import com.pug.zixun.common.anno.IgnoreToken;
import com.pug.zixun.common.enums.AdminErrorResultEnum;
import com.pug.zixun.common.utils.pwd.MD5Util;
import com.pug.zixun.config.jwt.JwtServer;
import com.pug.zixun.config.validator.PugAssert;
import com.pug.zixun.domain.User;
import com.pug.zixun.service.UserService;
import com.pug.zixun.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PassportLoginController extends PugAssert {

    @Autowired
    private UserService service;
    @Autowired
    private JwtServer jwtServer;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @PostMapping("/user/login")
    @IgnoreToken
    public UserBo login(@RequestBody UserVO userVo) {
        //通过断言来判定用户输入的账号密码是否为空
        isEmptyEx(userVo.getUsername(),AdminErrorResultEnum.USERNAME_IS_NULL);
        isEmptyEx(userVo.getPassword(),AdminErrorResultEnum.PASSWORD_IS_NULL);
        //调用登陆服务，返回查找到的用户
        User dbLoginUser = service.login(userVo);
        //断言判断用户输入的账号存在对应的用户
        isNullEx(dbLoginUser,AdminErrorResultEnum.USER_NOT_FOUND);
        String password = MD5Util.md5slat(userVo.getPassword());
        //判断数据库返回的密码是否与用户输入的相同
        boolean isLogin = dbLoginUser.getPassword().equalsIgnoreCase(password);
        //如果输入的密码有误，抛出异常
        isFalseEx(isLogin,AdminErrorResultEnum.PASSWORD_IS_FALSE);
        //根据用户生成token
        UserBo userBo = new UserBo();
        userVo.setId(dbLoginUser.getId());
        String token = jwtServer.createToken(userVo);
        userBo.setToken(token);
        //注意清空敏感信息
        dbLoginUser.setPassword(null);
        userBo.setUser(dbLoginUser);
        //登录下线
        String tokenuuid = UUID.randomUUID().toString();
        String tokenuuidKey = "pug:user:login:"+dbLoginUser.getId();
        redisTemplate.opsForValue().set(tokenuuidKey,tokenuuid);
        userBo.setTokenUUid(tokenuuid);

//        String tokenKey = "pug:user:login:token:"+token;
//        redisTemplate.opsForValue().set(tokenKey,JwtServer.TOKEN_EXPIRE_TIME*2);
        return userBo;
    }

}
