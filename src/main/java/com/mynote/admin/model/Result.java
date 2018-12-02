package com.mynote.admin.model;

public class Result<T> {
    public static final int SUCCESS_CODE = 200;
    public static final int EEROR_CODE = 404;

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public void setSuccessData(T data){
        this.data = data;
        this.code = SUCCESS_CODE;
        this.msg = "";
    }

    public void setError(String msg){
        this.code = EEROR_CODE;
        this.msg = msg;
    }
}
