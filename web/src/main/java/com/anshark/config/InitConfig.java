package com.anshark.config;

import com.anshark.netty.websocket.NettyWebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/14 13:21
 */
@Configuration
@Slf4j
public class InitConfig implements CommandLineRunner {

    @Value("${netty.websocket.port}")
    int port;

    @Override
    public void run(String... args) throws Exception {
        nettyWebsocketServer();
    }

    /**
     * 启动netty websocket
     */
    void nettyWebsocketServer() {
        log.info("port -> {}", port);
        NettyWebSocketServer nettyWebSocketServer = new NettyWebSocketServer();
        nettyWebSocketServer.start(port);
        log.info("nettyWebsocketServer启动成功");
    }
}
