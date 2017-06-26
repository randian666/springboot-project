/*--------------------------------------------------------------------------
 *  Copyright (c) 2010-2020, Elon.su All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the elon developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: Elon.su, you can also mail dennisit@163.com
 *--------------------------------------------------------------------------
*/
package com.springboot.websocket.endpoint;

import com.springboot.websocket.interceptor.LogHubHandshakeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Elon.su on 17/6/26.
 */
@Service
public class LogHubEndpoint implements WebSocketHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LogHubEndpoint.class);

    private static CopyOnWriteArrayList<WebSocketSession> onLines = new CopyOnWriteArrayList<WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOG.info("[LogHub]连接成功");
        onLines.add(session);
        String user = session.getAttributes().get(LogHubHandshakeInterceptor.SOCKET_SIGN_U).toString();
        LOG.info("[LogHub]欢迎" + user + "登陆到日志中心");
        if(StringUtils.isEmpty(user)){
            session.sendMessage(new TextMessage("欢迎" +user+ "使用LogHub"));
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        TextMessage text = new TextMessage(message.getPayload() + "");
        String content = text.getPayload();
        System.out.println(content);
        session.sendMessage(text);
        broadcastMessage(message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable error) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        LOG.error("[LogHub]连接出错:" + error.toString());
        onLines.remove(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        LOG.error("[LogHub]连接已关闭.");
        onLines.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     * @param message
     */
    public void broadcastMessage(WebSocketMessage<?> message) {
        for (WebSocketSession user : onLines) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                LOG.error("[LogHub]推送消息出错" + e.getLocalizedMessage(), e);
            }
        }
    }

    /**
     * 给特定用户发送消息
     * @param username
     * @param message
     */
    public void pointMessage(String username, TextMessage message) {
        if(StringUtils.isEmpty(username)){
            return;
        }
        for (WebSocketSession user : onLines) {
            if (username.equals(user.getAttributes().get(LogHubHandshakeInterceptor.SOCKET_SIGN_U))) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    LOG.error("[LogHub]推送消息出错" + e.getLocalizedMessage(), e);
                }
                break;
            }
        }
    }

}
