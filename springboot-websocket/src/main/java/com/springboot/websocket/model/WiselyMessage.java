package com.springboot.websocket.model;

/**
 * 浏览器向服务端发送的消息
 * Created by liuxun on 2017/6/23.
 */
public class WiselyMessage {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
