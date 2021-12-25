package com.astonm.springbootBaseProject.common.response;


@SuppressWarnings({"rawtypes"})
public class ResponseData<T> {
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAILURE = -1;

    private int code;

    private String msg;

    private boolean success;

    private T data;

    public ResponseData() {}

    public ResponseData(int code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public ResponseData<T> setData(T data) {
        this.data = data;
        return this;
    }


    public static ResponseData success() {
        return success(SUCCESS);
    }

    public static ResponseData success(String msg) {
        return success(CODE_SUCCESS, msg);
    }

    public static ResponseData success(int code, String message) {
        return new ResponseData(code, message, true);
    }

    public static ResponseData failure() {
        return failure(FAILURE);
    }

    public static ResponseData failure(String message) {
        return failure(CODE_FAILURE, message);
    }

    public static ResponseData failure(int code, String message) {
        return new ResponseData(code, message, false);
    }
}
