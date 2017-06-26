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
package com.springboot.websocket.config;

import com.springboot.websocket.endpoint.LogHubEndpoint;
import com.springboot.websocket.interceptor.LogHubHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Elon.su on 17/6/26.
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class EndpointWebSocketConfigure extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Autowired
    private LogHubEndpoint logHubEndpoint;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //注册处理拦截器,拦截url为socketServer的请求
        registry.addHandler(logHubEndpoint, "/logHub").addInterceptors(new LogHubHandshakeInterceptor());

        //注册SockJs的处理拦截器,拦截url为/sockjs/socketServer的请求
        registry.addHandler(logHubEndpoint, "/sockjs/logHub").addInterceptors(new LogHubHandshakeInterceptor()).withSockJS();
    }

}