package com.pug.zixun.common.exceptions;

public interface PugException{

    public Integer getCode();

    public void setCode(Integer code);

    public String getMsg();

    public void setMsg(String msg);
}
