package com.pug.zixun.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
//    状态码
    private Integer code;
//    状态信息
    private String msg;
//    返回数据
    private Object data;

    public static R success(AdminResulInterface result,Object data){
        return new R(result.getCode(),result.getMsg(),data);
    }
    public static R fail(AdminResulInterface result){
        return new R(result.getCode(),result.getMsg(),null);
    }
    public R setMsg(String message){
        this.setMsg(message);
        return this;
    }
    public R setCode(Integer statusCode){
        this.setCode(statusCode);
        return this;
    }
}
