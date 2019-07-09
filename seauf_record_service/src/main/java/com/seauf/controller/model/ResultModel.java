package com.seauf.controller.model;

import java.io.Serializable;

public class ResultModel<T> implements Serializable {
    private static final long serialVersionUID = 5576237395711742681L;
    public static final Integer SUCCESS = 0;
    public static final Integer SUCCESS_1 = 1;
    public static final String MSG_SUCCESS_DESC = "操作成功！";
    public static final Integer ERROR = -1;
    public static final String MSG_ERROR_DESC = " 系统忙！";
    public static final String MSG_ERROR_SIGN = " 请求签名错误！";
    public static final Integer ILLEGAL = -2;
    public static final String MSG_ILLEGAL_DESC = "参数不正确！";
    public static final Integer BIND_ERROR = -3;
    public static final String BIND_ERROR_DESC = "微信绑定用户失败！";

    public static final Integer WITHOUT_BIND_ERROR = -4;
    public static final String WITHOUT_BIND_ERROR_DESC = "请先绑定小程序！";
    private int code = 0;
    private String msg = MSG_SUCCESS_DESC;
    private T data;
    private int stamp = 0;

    public ResultModel() {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data == null ? null : this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "Result [code=" + this.code + ", msg=" + this.msg + "]";
    }

    public int getStamp() {
        return this.stamp;
    }

    public void setStamp(int stamp) {
        this.stamp = stamp;
    }
}

