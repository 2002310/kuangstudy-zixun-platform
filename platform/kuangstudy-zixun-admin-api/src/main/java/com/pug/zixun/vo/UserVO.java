package com.pug.zixun.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends ParentVO{
    private String username;
    private String pwd;
    private Integer age;
    private Integer sex;
    private String phone;
    private String idCard;
}
