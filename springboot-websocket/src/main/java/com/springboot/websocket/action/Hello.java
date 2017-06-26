package com.springboot.websocket.action;

import com.springboot.websocket.model.WiselyMessage;
import com.springboot.websocket.model.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * WebSocket广播式
 * Created by LiuXun on 2017/3/18.
 */
@Controller
public class Hello {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello boot";
    }

    /**
     * 当服务端有消息时，会对订阅@SendTo中的路径的浏览器发送消息
     * @param message
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/say")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return new WiselyResponse("hello,"+message.getMessage());
    }

    /**
     * 广播式消息-页面
     * @param map
     * @return
     */
    @RequestMapping("/view")
    public String helloThy(Map<String,Object> map) {

        return"/hello";
    }

}
