package com.pug.zixun.bo;

import com.pug.zixun.domain.User;
import com.pug.zixun.vo.UserVO;
import lombok.Data;

@Data
public class UserBo implements java.io.Serializable {
    private String token;
    private User user;
}
