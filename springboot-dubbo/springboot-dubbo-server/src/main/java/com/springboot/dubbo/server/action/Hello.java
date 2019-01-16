package com.springboot.dubbo.server.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LiuXun on 2017/3/18.
 */
@RestController
public class Hello {
    @RequestMapping("/hello")
    public String hello(){
        return "hello boot";
    }

    @RequestMapping("/sendMsg")
    public String welcome(String name) {
        return "hello "+name;
    }
}
