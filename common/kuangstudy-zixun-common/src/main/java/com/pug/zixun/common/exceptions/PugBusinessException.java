package com.pug.zixun.common.exceptions;

import com.pug.zixun.common.enums.AdminResulInterface;

public class PugBusinessException extends RuntimeException implements PugException{
    private Integer code;
    private String msg;

    public PugBusinessException(AdminResulInterface resulInterface){
        super(resulInterface.getMsg());
        this.code = resulInterface.getCode();
        this.msg = resulInterface.getMsg();
    }
    private PugBusinessException(Integer code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }
    @Override
    public Integer getCode() {
        return code;
    }
    @Override
    public void setCode(Integer code) {
        this.code = code;
    }
    @Override
    public String getMsg() {
        return msg;
    }
    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
