package com.longjiang.jiangxia.demo1.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.longjiang.jiangxia.demo1.enumset.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author gavin
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class Response<T> {
    @ApiModelProperty("错误代码")
    private String code;

    @ApiModelProperty("错误消息")
    private String msg;

    @ApiModelProperty("实际数据")
    private T data;


    /**
     * 成功消息
     * @return
     */
    public static <T> Response<T> success() {
        return rspMsg(ResponseEnum.SUCCESS);
    }

    /**
     * @title 成功消息
     * @return
     */
    public static <T> Response<T> success(String msg) {
        Response<T> responseData = new Response<T>();
        responseData.setCode(ResponseEnum.SUCCESS.getCode());
        responseData.setMsg(msg);
        return responseData;
    }

    /**
     * @title 失败消息
     * @return
     */
    public static <T> Response<T> fail(String msg) {
        Response<T> responseData = new Response<T>();
        responseData.setCode(ResponseEnum.OPERATION_FAILED.getCode());
        responseData.setMsg(msg);
        return responseData;
    }


    /**
     * @title 失败消息
     * @return
     */
    public static <T> Response<T> fail() {
        return rspMsg(ResponseEnum.SERVER_INNER_ERR);
    }

    /**
     * @title 自定义消息
     * @param responseEnum
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
     * @param code
     * @param msg
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

