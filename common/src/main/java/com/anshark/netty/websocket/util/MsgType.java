package com.anshark.netty.websocket.util;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/14 13:39
 */
public enum MsgType {

    CONNECTION_MSG(1, "连接消息");

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
