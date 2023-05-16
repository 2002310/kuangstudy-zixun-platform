package com.pug.zixun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pug.zixun.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
