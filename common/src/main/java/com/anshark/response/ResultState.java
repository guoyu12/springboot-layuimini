package com.anshark.response;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc 响应信息类
 */
public enum ResultState {

    /**
     * 系统处理成功
     */
    SYS_SUCCESS(0, "success"),
    /**
     * 系统处理失败
     */
    SYS_ERROR(1, "error"),

    /**
     * 未知路径
     */
    SYS_UNKOWN_PATH(2,"未知路径"),

    /**
     * 退出状态
     */
    SYS_EXIT(3,"已退出");

    int code;

    String msg;

    ResultState(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
