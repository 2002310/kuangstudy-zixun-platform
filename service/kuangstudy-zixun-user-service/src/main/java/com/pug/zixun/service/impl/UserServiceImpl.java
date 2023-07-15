package com.pug.zixun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pug.zixun.domain.User;
import com.pug.zixun.mapper.UserMapper;
import com.pug.zixun.service.UserService;
import com.pug.zixun.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User login(UserVO uservo) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,uservo.getUsername());
        User user = this.getOne(lambdaQueryWrapper);
        return user;
    }
}
