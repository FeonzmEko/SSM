package com.itheima.domain;

import java.util.List;

public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result(boolean data, Book book, Integer integer) {
    }

    public Result(Object data, Integer code) {
        this.data = data;
        this.code = code;
    }


    /**
     * 获取
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "Result{data = " + data + ", code = " + code + ", msg = " + msg + "}";
    }
}
