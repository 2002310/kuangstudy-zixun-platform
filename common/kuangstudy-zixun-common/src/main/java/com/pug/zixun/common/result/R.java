package com.pug.zixun.common.result;

import com.pug.zixun.common.enums.AdminResulInterface;
import com.pug.zixun.common.enums.AdminSuccessResultEnum;
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
//    默认的成功，传入参数即可
    public static R success(Object data) {
        return new R(AdminSuccessResultEnum.ADMIN_SUCCESS.getCode(), AdminSuccessResultEnum.ADMIN_SUCCESS.getMsg(), data);
    }
//    自定义成功返回
    public static R success(Integer code,String msg,Object data){
        return new R(code,msg,data);
    }
//    定义成功枚举返回
    public static R success(AdminResulInterface result, Object data){
        return new R(result.getCode(),result.getMsg(),data);
    }
//    定义失败枚举返回
    public static R fail(AdminResulInterface result){
        return new R(result.getCode(),result.getMsg(),null);
    }
//    定义有返回data的枚举失败返回
    public static R fail(AdminResulInterface result, Object data){
        return new R(result.getCode(),result.getMsg(),data);
    }
//    自定义失败返回
    public static R fail(Integer code,String msg,Object data){
        return new R(code,msg,data);
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
