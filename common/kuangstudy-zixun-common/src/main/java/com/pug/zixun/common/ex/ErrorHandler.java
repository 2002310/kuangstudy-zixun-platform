package com.pug.zixun.common.ex;

import com.pug.zixun.common.enums.AdminResulInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorHandler {
    //    状态码
    private Integer code;
    //    状态信息
    private String msg;
    //    返回数据
    private Object data;
    public static ErrorHandler fail(AdminResulInterface adminResulInterface,Object o){
        return new ErrorHandler(adminResulInterface.getCode(),adminResulInterface.getMsg(),o);
    }
    public static ErrorHandler fail(int code,String msg,Object o){
        return new ErrorHandler(code,msg,o);
    }
}
