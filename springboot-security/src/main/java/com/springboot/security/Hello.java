package com.springboot.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
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
     * 需要security登录才能访问
     * @return
     */
    @RequestMapping("/security")
    @ResponseBody
    public String security(){
        return "hello security";
    }

    /**
     * 需要security登录才能访问
     * @return
     */
    @RequestMapping("/security1")
    @ResponseBody
    public String security1(){
        return "hello security1";
    }
}
