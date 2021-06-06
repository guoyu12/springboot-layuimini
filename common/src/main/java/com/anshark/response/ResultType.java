package com.anshark.response;

import lombok.Data;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Data
public class ResultType {

    private int code;

    private String msg;

    private Object data;

    private Integer count;

    public ResultType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultType(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultType(int code, String msg, Object data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public ResultType(ResultState resultState) {
        this.code = resultState.code;
        this.msg = resultState.msg;
    }

    public ResultType(ResultState resultState, Object data) {
        this.code = resultState.code;
        this.msg = resultState.msg;
        this.data = data;
    }

    public ResultType(ResultState resultState, Object data, Integer count) {
        this.code = resultState.code;
        this.msg = resultState.msg;
        this.data = data;
        this.count = count;
    }

    public static ResultType success(Object data) {
        return new ResultType(ResultState.SYS_SUCCESS.code, ResultState.SYS_SUCCESS.msg, data);
    }

    public static ResultType success(Object data, Integer count) {
        return new ResultType(ResultState.SYS_SUCCESS.code, ResultState.SYS_SUCCESS.msg, data, count);
    }

    public static ResultType success() {
        return success(null);
    }

    public static ResultType error(String msg) {
        return new ResultType(ResultState.SYS_ERROR.code, msg);
    }


}
