package com.anshark.netty.websocket.util;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/14 13:39
 */
public enum MsgType {

    /**
     * 连接消息
     */
    CONNECTION_MSG(1, "连接消息"),
    /**
     * 表单消息
     */
    REPORT_FORMS(2, "表单消息"),

    /**
     * 快捷入口
     */
    QUICK_ENTRY(3, "快捷入口"),

    /**
     * 系统公告
     */
    SYS_NOTICES(4,"系统公告");

    int code;

    String msg;

    MsgType(int code, String msg) {
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
