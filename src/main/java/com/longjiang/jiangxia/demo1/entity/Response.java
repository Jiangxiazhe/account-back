package com.longjiang.jiangxia.demo1.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.longjiang.jiangxia.demo1.enumset.ResponseEnum;

/**
 * @author gavin
 * @title 响应实体类
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private String code;

    private String msg;

    private T data;


    /**
     * @title 成功消息
     * @param ResponseEnum
     * @return
     */
    public static <T> Response<T> success() {
        return rspMsg(ResponseEnum.SUCCESS);
    }

    /**
     * @title 失败消息
     * @param ResponseEnum
     * @return
     */
    public static <T> Response<T> fail() {
        return rspMsg(ResponseEnum.SERVER_INNER_ERR);
    }

    /**
     * @title 自定义消息
     * @param ResponseEnum
     * @return
     */
    public static <T> Response<T> rspMsg(ResponseEnum responseEnum) {
        Response<T> message = new Response<T>();
        message.setCode(responseEnum.getCode());
        message.setMsg(responseEnum.getMsg());
        return message;
    }

    /**
     * @title 自定义消息
     * @param errcode
     * @param errmsg
     * @return
     */
    public static <T> Response<T> rspMsg(String code , String msg) {
        Response<T> message = new Response<T>();
        message.setCode(code);
        message.setMsg(msg);
        return message;
    }

    /**
     * @title 返回数据
     * @param data
     * @return
     */
    public static <T> Response<T> rspData(T data) {
        Response<T> responseData = new Response<T>();
        responseData.setCode(ResponseEnum.SUCCESS.getCode());
        responseData.setData(data);
        return responseData;
    }

    /**
     * @title 返回数据-自定义code
     * @param data
     * @return
     */
    public static <T> Response<T> rspData(String code , T data) {
        Response<T> responseData = new Response<T>();
        responseData.setCode(code);
        responseData.setData(data);
        return responseData;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

