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
package com.springboot.websocket.action;

import com.springboot.websocket.endpoint.LogHubEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;

/**
 * Created by Elon.su on 17/6/26.
 */
@Controller
public class LogHub {

    @Resource
    private LogHubEndpoint logHubEndpoint;

    @RequestMapping("/logHub")
    @ResponseBody
    public String hello(){
        String txt = "后端推流测试";
        logHubEndpoint.broadcastMessage(new TextMessage(txt));
        return txt;
    }

}
