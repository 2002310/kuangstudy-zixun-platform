package com.pug.zixun.common;

public enum AdminResultEnum implements AdminResulInterface{
    ADMIN_SUCCESS(200,"请求成功"),
    ADMIN_PAGE_NOTFOUND(404,"页面未找到"),
    ADMIN_SERVER_ERROR(500,"服务器异常"),
    ADMIN_RESULT_RANGE(206,"页面分段返回中")
    ;
    private Integer code;
    private String msg;

    AdminResultEnum(Integer code, String msg) {
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
