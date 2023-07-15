package com.pug.zixun.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends ParentVO implements java.io.Serializable{
    private Long id;
    private String username;
    private String password;
    private String code;
    private String uuid;
}
