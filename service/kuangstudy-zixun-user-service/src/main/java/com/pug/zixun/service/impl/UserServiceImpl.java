package com.pug.zixun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pug.zixun.domain.User;
import com.pug.zixun.mapper.UserMapper;
import com.pug.zixun.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
