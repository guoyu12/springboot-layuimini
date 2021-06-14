package com.anshark.netty.websocket;

import com.anshark.netty.websocket.channelinitializer.CustomerChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/14 13:10
 */
public class NettyWebSocketServer {

    public void start(int port) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    //日志处理器
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new CustomerChannelInitializer());
            //绑定端口并且同步处理
            ChannelFuture sync = bootstrap.bind(port).sync();

            //对关闭通道监听
            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }

}
