package com.pug.zixun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pug.zixun.domain.User;
import com.pug.zixun.vo.UserVO;

public interface UserService extends IService<User> {
    public User login(UserVO uservo);
}
