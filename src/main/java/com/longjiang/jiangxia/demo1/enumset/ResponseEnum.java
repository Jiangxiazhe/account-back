package com.longjiang.jiangxia.demo1.config;

/**
 * @author gain
 * @title 响应消息枚举
 */
public enum ResponseEnum {
    // 可以根据自己的实际需要增加状态码
    SUCCESS("0", "ok"),
    SERVER_INNER_ERR("1","系统繁忙"),
    PARAM_LACK("2" , "非法参数"),
    OPERATION_FAILED("3" ,"操作失败"),
    ;

    private String code;
    private String msg;

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
