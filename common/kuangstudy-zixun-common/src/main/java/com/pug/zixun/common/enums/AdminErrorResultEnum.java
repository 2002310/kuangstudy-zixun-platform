package com.pug.zixun.common.enums;

public enum AdminErrorResultEnum implements AdminResulInterface{
    FILE_NOT_FOUND(401,"文件未找到"),
    USER_NOT_FOUND(410,"用户查询失败，用户不存在"),
    USER_FORBID(415,"用户异常，请联系管理员"),
    RUNTIME_ERROR(420,"运行时异常"),
    ORDER_EXCEPTION(430,"订单异常"),
    TOKEN_EXCEPTION(431,"用户登录信息过期，请重新登录"),
    VALIDATOR_EXCEPTION(440,"验证异常"),
    BUSINESS_EXCEPTION(450,"业务异常"),
    TOKEN_ERROR(10046,"用户token失效"),
    TOKEN_NOT_ACTIVITY(10049,"无效的token"),
    TOKEN_IS_NULL(10040,"无token"),
    TOKEN_NOT_FOUND(10047,"用户token为空"),
    USERNAME_IS_NULL(10047,"用户token为空"),
    PASSWORD_IS_NULL(10051,"用户密码为空"),
    PASSWORD_IS_FALSE(10052,"用户密码错误"),
    LOGIN_ERROR(10050,"账号密码错误，登陆失败"),
    ADMIN_PAGE_NOTFOUND(404,"页面未找到"),
    ADMIN_SERVER_ERROR(500,"服务器异常");

    private Integer code;
    private String msg;

    AdminErrorResultEnum(Integer code, String msg) {
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
