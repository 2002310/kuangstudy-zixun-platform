package com.pug.zixun.common.enums;

public enum AdminErrorResultEnum implements AdminResulInterface{
    FILE_NOT_FOUND(401,"文件未找到"),
    USER_NOT_FOUND(410,"用户查询失败，用户不存在"),
    RUNTIME_ERROR(420,"运行时异常"),
    ORDER_EXCEPTION(430,"订单异常"),
    VALIDATOR_EXCEPTION(440,"验证异常"),
    BUSINESS_EXCEPTION(450,"业务异常"),
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
