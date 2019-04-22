package com.terrace.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @project: synchronized
 * @author: zhs
 * @date: 2019/3/12 10:51
 * @package: com.food.service
 * @description:
 */

@Component
@ServerEndpoint("/websocket")
@Slf4j
public class WebSocket {

    private Session session;
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("websocket 有新的连接，总数：{}", webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("websocket 连接断开，总数：{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("websocket 收到客户端发送的消息：{}", message);
        sendMessage(message);
    }


    public void sendMessage(String message) {
        for (WebSocket webSocket : webSocketSet) {
            log.info("websocket 消息广播消息：message{}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                log.error("捕获wensocket的异常{}", e.getMessage());
            }
        }
    }
}
