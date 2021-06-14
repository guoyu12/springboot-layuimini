package com.anshark.netty.websocket.handler;

import com.alibaba.fastjson.JSONObject;
import com.anshark.common.Constant;
import com.anshark.netty.websocket.util.MsgType;
import com.anshark.response.ResultType;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/14 13:15
 */
@Slf4j
public class CustomerSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    public static Map<String, Channel> map = new HashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        ResultType resultType = JSONObject.parseObject(textWebSocketFrame.text(), ResultType.class);
        log.info("消息 -> " + resultType.getCode() + resultType.getMsg());
        if (MsgType.CONNECTION_MSG.getCode() == resultType.getCode()) {
            map.put(resultType.getMsg(), channelHandlerContext.channel());
        }

        System.out.println(map.size());

    }

    /**
     * 链接成功
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("连接成功");
    }

    /**
     * 断开连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("断开连接");
        Iterator<Map.Entry<String, Channel>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Channel> next = iterator.next();
            if (next.getValue() == ctx.channel()) {
                iterator.remove();
            }
        }

    }

    /**
     * 异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
        log.info("异常");
    }
}
