package com.pug.zixun.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("kss_user")
public class User implements java.io.Serializable{
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String nickname;
    private String username;
    private Integer age;
    private String sign;
    private Integer sex;
    private Integer views;
    private String job;
    private String jobyear;
    private String address;
    private String description;
    private String country;
    private String province;
    private String city;
    private String telephone;
    private String weixincode;
    private String education;
    private String birthday;
    private String avatar;
    private String bgimg;
    private Integer vip;
    private Date vipTime;
    private Integer cron;
    private Integer studydays;
    private Integer isDelete;
    private Integer forbbiden;
    private String qqcode;
    private String code;
    private String role;
    private String password;
    private String openid;
    private String unionid;
    private Integer fans;
    private Integer gznums;
    private String bloglink;
    private String giteelink;
    private String bilibililink;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;



}
