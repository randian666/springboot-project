package com.springboot.dubbo.consume.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.dubbo.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LiuXun on 2017/3/18.
 */
@RestController
public class Hello {

    @Reference(version = "1.0.0")
    HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello boot";
    }

    @RequestMapping("/sendMsg")
    public String welcome(String name) {
        return helloService.sayHello(name);
    }
}
