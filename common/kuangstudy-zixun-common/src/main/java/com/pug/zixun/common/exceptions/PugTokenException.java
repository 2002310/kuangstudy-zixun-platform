package com.pug.zixun.common.exceptions;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.pug.zixun.common.enums.AdminResulInterface;

public class PugTokenException extends TokenExpiredException implements PugException {
    private Integer code;
    private String msg;
    public PugTokenException(AdminResulInterface message) {
        super(message.getMsg());
        this.code = message.getCode();
        this.msg = message.getMsg();

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
