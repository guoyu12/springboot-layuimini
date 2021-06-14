package com.anshark.netty.websocket.channelinitializer;

import com.anshark.netty.websocket.handler.CustomerSocketHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/14 13:13
 */
public class CustomerChannelInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipeline = socketChannel.pipeline();
        //基于Http协议 使用http编码和解码器
        pipeline.addLast(new HttpServerCodec());
        //添加ChunkedWriteHandler处理器
        pipeline.addLast(new ChunkedWriteHandler());
        //http数据在传输过程中是分段的 当浏览器发送大量数据时会请求多次
        pipeline.addLast(new HttpObjectAggregator(9999));
        //对于websocket 它的数据是以帧的形式传递 WebSocketServerProtocolHandler将http协议升级为ws协议保持长链接
        pipeline.addLast(new WebSocketServerProtocolHandler("/websocket"));
        //自定义handler 处理业务逻辑
        pipeline.addLast(new CustomerSocketHandler());
    }
}
