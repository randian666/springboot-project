package com.springboot.websocket.model;

/**
 * 服务器想浏览器发送的此类消息
 * Created by liuxun on 2017/6/23.
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage){
        this.responseMessage=responseMessage;
    }
    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
