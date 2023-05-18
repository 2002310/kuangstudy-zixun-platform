package com.pug.zixun.common.enums;

public enum AdminSuccessResultEnum implements AdminResulInterface{
    ADMIN_SUCCESS(200,"请求成功"),

    ADMIN_RESULT_RANGE(206,"页面分段返回中")
    ;
    private Integer code;
    private String msg;

    AdminSuccessResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
