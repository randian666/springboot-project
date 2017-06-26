package com.springboot.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * WebSocket广播式 @EnableWebSocketMessageBroker注解表示开启使用STOMP协议来传输基于代理的消息
 * 1、@EnableWebSocketMessageBroker 注解开启使用STOMP协议来传输基于代理（message broker）的消息，这时控制器支持使用@MessageMapping。
 * 2、注册STOMP协议的节点（endpoint），并且映射指定的URL
 * 3、注册一个STOMP的endpoint，并指定使用SockJS协议
 * 4、配置消息代理 message broker
 * 5、广播式应配置一个/topic消息代理
 * Created by liuxun on 2017/6/23.
 */
@Configuration
@EnableWebSocketMessageBroker //1
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {//2
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();//3
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//4
        registry.enableSimpleBroker("/topic");//5
    }
}
